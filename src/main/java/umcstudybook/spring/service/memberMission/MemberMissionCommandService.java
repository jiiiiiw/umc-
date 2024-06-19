package umcstudybook.spring.service.memberMission;

import umcstudybook.spring.domain.mapping.MemberMission;
import umcstudybook.spring.web.dto.MemberMissionRequestDTO;

public interface MemberMissionCommandService {

    MemberMission joinMemberMission(MemberMissionRequestDTO.JoinMemberMissionDTO request);
}
