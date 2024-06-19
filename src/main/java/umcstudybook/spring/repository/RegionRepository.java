package umcstudybook.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcstudybook.spring.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}