package umcstudybook.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umcstudybook.spring.domain.Mission;
import umcstudybook.spring.domain.Store;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findMissionsByStoreIsOrderByCreatedAtDesc(Pageable pageable, Store store);
}
