package ao.co.mapaDeBuraco.controller;

import ao.co.mapaDeBuraco.model.Admin;
import ao.co.mapaDeBuraco.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Admin> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(adminService.findById(id));

    }
}
