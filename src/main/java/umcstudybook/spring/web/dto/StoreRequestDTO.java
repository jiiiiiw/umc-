package umcstudybook.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umcstudybook.spring.validation.annotation.ExistRegion;

public class StoreRequestDTO {

    @Getter
    public static class JoinStoreDTO {

        @NotNull
        @Size(max = 50)
        private String name;

        @NotNull
        @Size(max = 50)
        private String address;

        private Float score;

        @ExistRegion
        private Long regionId;
    }
}
