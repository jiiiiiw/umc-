package umcstudybook.spring.service.memberMission;

import org.springframework.data.domain.Page;
import umcstudybook.spring.domain.enums.MissionStatus;
import umcstudybook.spring.domain.mapping.MemberMission;

public interface MemberMissionQueryService {
    Page<MemberMission> findMissionByUserAndStatus(Long memberId, MissionStatus status, Integer page);
}