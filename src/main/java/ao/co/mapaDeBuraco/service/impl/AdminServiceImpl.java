package ao.co.mapaDeBuraco.service.impl;

import ao.co.mapaDeBuraco.model.Admin;
import ao.co.mapaDeBuraco.repositories.AdminRepository;
import ao.co.mapaDeBuraco.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin findById(Long id) {
        Optional<Admin> user = adminRepository.findById(id);
        return user.orElse(null);
    }
}
