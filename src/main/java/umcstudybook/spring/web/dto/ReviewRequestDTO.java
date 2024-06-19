package umcstudybook.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umcstudybook.spring.validation.annotation.ExistMember;
import umcstudybook.spring.validation.annotation.ExistStore;

public class ReviewRequestDTO {

    @Getter
    public static class JoinReviewDTO {

        @NotNull
        private String body;

        private Float score;

        @ExistMember
        private Long memberId;

        @ExistStore
        private Long storeId;
    }
}
