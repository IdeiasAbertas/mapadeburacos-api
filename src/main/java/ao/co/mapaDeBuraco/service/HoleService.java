package ao.co.mapaDeBuraco.service;


import ao.co.mapaDeBuraco.model.Hole;
import ao.co.mapaDeBuraco.model.dto.response.HoleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HoleService {
    Hole findById(Long id);

    List<Hole> findAll();

    Hole create(Hole hole);

    Hole update(Long id, HoleDTO holeDTO);

    Hole closeHole(Long id);


    void delete(Long id);
}
