package ao.co.mapaDeBuraco.controller;

import ao.co.mapaDeBuraco.model.Hole;
import ao.co.mapaDeBuraco.model.dto.response.HoleDTO;
import ao.co.mapaDeBuraco.model.dto.resquest.HoleDTORequest;
import ao.co.mapaDeBuraco.model.dto.resquest.HoleDTOUpdateRequest;
import ao.co.mapaDeBuraco.service.HoleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value = "API MAPA DE BURACOS")
public class HoleController {

    @Autowired
    HoleService holeService;

    private final ObjectMapper mapper = new ObjectMapper();

    @GetMapping(value = "/hole/{id}")
    @ApiOperation(value = "List hole information by id")
    public ResponseEntity<HoleDTO> findById(@PathVariable Long id){
        Hole hole = holeService.findById(id);
        return ResponseEntity.ok(new HoleDTO(hole));

    }
    @GetMapping(value = "/hole")
    @ApiOperation(value = "List all hole information")
    public ResponseEntity<List<HoleDTO>> findAll() {
        List<Hole> holes = holeService.findAll();
        return ResponseEntity.ok(holes.stream().map(HoleDTO::new).collect(Collectors.toList()));
    }

    @PostMapping(value = "/hole")
    @ApiOperation(value = "Register new hole information")
    public ResponseEntity<HoleDTO> create(@Valid @RequestParam String holeData, @RequestParam("picture") final MultipartFile picture) throws IOException {


        final var holeDTORequest = mapper.readValue(holeData, HoleDTORequest.class);
        holeDTORequest.setPicture(picture.getInputStream().readAllBytes());
        var hole = holeService.create(holeDTORequest);
        var holeDTO = new HoleDTO();
        BeanUtils.copyProperties(hole, holeDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(holeDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(holeDTO);
    }


    @PutMapping(value = "/hole/{id}")
    @ApiOperation(value = "Update hole information")
    public ResponseEntity<Hole> update2(@PathVariable Long id, @RequestParam String holeData , @RequestParam(value = "picture", required = false) final MultipartFile picture ) throws IOException{

    final var holeDTOUpdateRequest = mapper.readValue(holeData, HoleDTOUpdateRequest.class);

        if (picture != null){
            holeDTOUpdateRequest.setPicture(picture.getInputStream().readAllBytes());
        }

    var hole = holeService.update2(id, holeDTOUpdateRequest);
        return ResponseEntity.ok(hole);
    }

    @DeleteMapping(value = "/hole/{id}")
    @ApiOperation(value = "Delete  hole information by id")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        holeService.delete(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping(value = "/hole/close/{id}")
    @ApiOperation(value = "Close  hole information ")
    public ResponseEntity<Hole> closeHole(@PathVariable Long id){
        Hole hole = holeService.closeHole(id);
        return ResponseEntity.ok().body(hole);
    }


}
