package ao.co.mapaDeBuraco.service.impl;

import ao.co.mapaDeBuraco.model.Admin;
import ao.co.mapaDeBuraco.model.dto.response.AdminDTO;
import ao.co.mapaDeBuraco.repositories.AdminRepository;
import ao.co.mapaDeBuraco.service.AdminService;
import ao.co.mapaDeBuraco.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin findById(Long id) {
        Optional<Admin> admin = adminRepository.findById(id);
        return admin.orElseThrow(() -> new ObjectNotFoundException("User not found: " + id));
    }

    @Override
    public List<Admin>  findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin create(Admin admin) {
        admin.setId(null);
        return adminRepository.save(admin);
    }

    @Override
    public Admin update(Long id, AdminDTO adminDTO) {
        //findById(id);
        Admin admin = adminRepository.getReferenceById(id);
            admin.setUserName(adminDTO.getUserName());
            admin.setEmail(adminDTO.getEmail());
            return adminRepository.save(admin);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        adminRepository.deleteById(id);
    }

}
