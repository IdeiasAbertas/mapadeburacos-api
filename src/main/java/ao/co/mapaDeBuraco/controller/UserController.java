package ao.co.mapaDeBuraco.controller;

import ao.co.mapaDeBuraco.model.Administrator;
import ao.co.mapaDeBuraco.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    AdministratorService administratorService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Administrator> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(administratorService.findById(id));

    }
}
