package ao.co.mapaDeBuraco.service;

import ao.co.mapaDeBuraco.model.Admin;
import ao.co.mapaDeBuraco.model.dto.response.AdminDTO;

import java.util.List;


public interface AdminService {
    Admin findById(Long id);
    List<Admin> findAll();

    Admin create(Admin admin);

    Admin update(Long id, AdminDTO adminDTO);

    void delete(Long id);


}
