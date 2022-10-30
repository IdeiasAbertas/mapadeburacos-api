package ao.co.mapaDeBuraco.service.impl;

import ao.co.mapaDeBuraco.model.Hole;
import ao.co.mapaDeBuraco.repositories.HoleRepository;
import ao.co.mapaDeBuraco.service.HoleService;
import ao.co.mapaDeBuraco.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HoleServiceImpl implements HoleService {

    @Autowired
    private HoleRepository holeRepository;

    @Override
    public Hole findById(Long id) {
        Optional<Hole> hole = holeRepository.findById(id);
        return hole.orElseThrow(() -> new ObjectNotFoundException("Hole not found: " + id));

        /*return hole.orElseThrow(() -> new ObjectNotFoundException("Hole not found: " + id +
                " Type: " + Hole.class.getName()));*/
    }
}
