package umcstudybook.spring.web.dto;

import lombok.Getter;
import umcstudybook.spring.validation.annotation.ExistMember;
import umcstudybook.spring.validation.annotation.ExistMission;

public class MemberMissionRequestDTO {

    @Getter
    public static class JoinMemberMissionDTO {

        @ExistMember
        private Long memberId;

        @ExistMission
        private Long missionId;
    }
}
