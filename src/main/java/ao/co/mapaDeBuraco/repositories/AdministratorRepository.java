package ao.co.mapaDeBuraco.repositories;

import ao.co.mapaDeBuraco.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
}
