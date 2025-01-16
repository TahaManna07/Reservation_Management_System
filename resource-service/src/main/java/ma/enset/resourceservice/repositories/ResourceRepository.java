package ma.enset.resourceservice.repositories;

import ma.enset.resourceservice.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
