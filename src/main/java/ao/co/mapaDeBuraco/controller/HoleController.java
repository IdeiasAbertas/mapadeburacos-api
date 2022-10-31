package ao.co.mapaDeBuraco.controller;

import ao.co.mapaDeBuraco.model.Hole;
import ao.co.mapaDeBuraco.model.dto.response.HoleDTO;
import ao.co.mapaDeBuraco.service.HoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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
    public ResponseEntity<Hole> create(@Valid @RequestBody Hole hole){
        hole = holeService.create(hole);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(hole.getId()).toUri();
        return ResponseEntity.created(uri).body(hole);
    }

    @PutMapping(value = "/hole/{id}")
    @ApiOperation(value = "Update hole information")
    public ResponseEntity<HoleDTO> update(@PathVariable Long id, @Valid @RequestBody HoleDTO holeDTO){
        Hole hole = holeService.update(id, holeDTO);
        return ResponseEntity.ok(new HoleDTO(hole));
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
