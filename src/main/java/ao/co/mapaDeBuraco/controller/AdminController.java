package ao.co.mapaDeBuraco.controller;

import ao.co.mapaDeBuraco.model.Admin;
import ao.co.mapaDeBuraco.model.dto.response.AdminDTO;
import ao.co.mapaDeBuraco.service.AdminService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API MAPA DE BURACOS")
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<AdminDTO> findById(@PathVariable Long id){
        Admin admin = adminService.findById(id);
        return ResponseEntity.ok(new AdminDTO(admin));
    }

    @GetMapping(value = "/user")
    public ResponseEntity<List<AdminDTO>> findAll() {
        List<Admin> admins = adminService.findAll();
        return ResponseEntity.ok(admins.stream().map(AdminDTO::new).collect(Collectors.toList()));
    }

    @PostMapping("/user")
    public ResponseEntity<Admin> create(@RequestBody Admin admin){
          admin = adminService.create(admin);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(admin.getId()).toUri();
        return ResponseEntity.created(uri).body(admin);
    }

    @PutMapping(value = "/user/{id}")
    public ResponseEntity<AdminDTO> update(@PathVariable Long id, @RequestBody AdminDTO adminDTO){
        Admin admin = adminService.update(id, adminDTO);
        return ResponseEntity.ok(new AdminDTO(admin));
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
      adminService.delete(id);
      return ResponseEntity.noContent().build();

    }
}
