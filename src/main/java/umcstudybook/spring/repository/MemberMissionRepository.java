package umcstudybook.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcstudybook.spring.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}
