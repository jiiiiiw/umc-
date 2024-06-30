package umcstudybook.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umcstudybook.spring.domain.Member;
import umcstudybook.spring.domain.enums.MissionStatus;
import umcstudybook.spring.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    Page<MemberMission> findMemberMissionsByMemberIsAndStatusIsOrderByCreatedAtDesc(Pageable pageable, Member member, MissionStatus status);
}
