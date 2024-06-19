package umcstudybook.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MemberMissionResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO {
        private Long id;
        private LocalDateTime createdAt;
    }
}
