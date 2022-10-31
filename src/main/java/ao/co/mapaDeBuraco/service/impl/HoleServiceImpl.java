package ao.co.mapaDeBuraco.service.impl;

import ao.co.mapaDeBuraco.enums.HoleStatus;
import ao.co.mapaDeBuraco.model.Hole;
import ao.co.mapaDeBuraco.model.dto.response.HoleDTO;
import ao.co.mapaDeBuraco.repositories.HoleRepository;
import ao.co.mapaDeBuraco.service.HoleService;
import ao.co.mapaDeBuraco.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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

    @Override
    public List<Hole> findAll() {
        return holeRepository.findAll();
    }

    @Override
    public Hole create(Hole hole) {
        hole.setId(null);
        return holeRepository.save(hole);
    }

    @Override
    public Hole update(Long id, HoleDTO holeDTO) {
        Hole hole = holeRepository.getReferenceById(id);
        hole.setPicture(holeDTO.getPicture());
        hole.setDescription(holeDTO.getDescription());
        hole.setLongitude(holeDTO.getLongitude());
        hole.setLatitude(holeDTO.getLatitude());
        hole.setNeighborhood(holeDTO.getNeighborhood());
        hole.setCity(holeDTO.getCity());
        hole.setUpdatedAt(holeDTO.getUpdatedAt(LocalDateTime.now()));
        hole.setHoleStatus(holeDTO.getHoleStatus());

        return holeRepository.save(hole);
    }

    @Override
    public Hole closeHole(Long id){
        Hole hole = holeRepository.getReferenceById(id);
        hole.setHoleStatus(HoleStatus.COVERED.getCode());
        hole.setUpdatedAt(LocalDateTime.now());
        hole.setClosedDate(LocalDateTime.now());
        return holeRepository.save(hole);

    }


    @Override
    public void delete(Long id) {
        findById(id);
        holeRepository.deleteById(id);

    }


}
