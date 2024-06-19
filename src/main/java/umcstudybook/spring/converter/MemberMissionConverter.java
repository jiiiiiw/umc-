package umcstudybook.spring.converter;

import umcstudybook.spring.domain.enums.MissionStatus;
import umcstudybook.spring.domain.mapping.MemberMission;
import umcstudybook.spring.web.dto.MemberMissionResponseDTO;

public class MemberMissionConverter {

    public static MemberMission toMemberMission(MissionStatus status) {
        return MemberMission.builder()
                .status(status)
                .build();
    }

    public static MemberMissionResponseDTO.JoinResultDTO toJoinResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.JoinResultDTO.builder()
                .id(memberMission.getId())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }
}
