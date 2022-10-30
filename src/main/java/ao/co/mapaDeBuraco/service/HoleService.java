package ao.co.mapaDeBuraco.service;


import ao.co.mapaDeBuraco.model.Hole;
import org.springframework.stereotype.Service;

@Service
public interface HoleService {
    Hole findById(Long id);
}
