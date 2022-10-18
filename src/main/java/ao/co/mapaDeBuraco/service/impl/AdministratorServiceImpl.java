package ao.co.mapaDeBuraco.service.impl;

import ao.co.mapaDeBuraco.model.Administrator;
import ao.co.mapaDeBuraco.repositories.AdministratorRepository;
import ao.co.mapaDeBuraco.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Override
    public Administrator findById(Long id) {
        Optional<Administrator> user = administratorRepository.findById(id);
        return user.orElse(null);
    }
}
