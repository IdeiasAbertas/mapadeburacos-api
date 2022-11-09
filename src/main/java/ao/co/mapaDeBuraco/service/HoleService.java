package ao.co.mapaDeBuraco.service;


import ao.co.mapaDeBuraco.model.Hole;
import ao.co.mapaDeBuraco.model.dto.response.HoleDTO;
import ao.co.mapaDeBuraco.model.dto.resquest.HoleDTORequest;

import ao.co.mapaDeBuraco.model.dto.resquest.HoleDTOUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HoleService {
    Hole findById(Long id);

    List<Hole> findAll();

    Hole create(HoleDTORequest holeDTORequest);

    Hole update(Long id, HoleDTO holeDTO);

    Hole update2(Long id, HoleDTOUpdateRequest holeDTOUpdateRequest);

    Hole closeHole(Long id);

    void delete(Long id);
}
