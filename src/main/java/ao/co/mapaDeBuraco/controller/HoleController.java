package ao.co.mapaDeBuraco.controller;

import ao.co.mapaDeBuraco.model.Admin;
import ao.co.mapaDeBuraco.model.Hole;
import ao.co.mapaDeBuraco.service.AdminService;
import ao.co.mapaDeBuraco.service.HoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hole")
public class HoleController {

    @Autowired
    HoleService holeService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Hole> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(holeService.findById(id));

    }
}
