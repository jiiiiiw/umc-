package umcstudybook.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcstudybook.spring.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
