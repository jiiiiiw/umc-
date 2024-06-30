package umcstudybook.spring.converter;

import umcstudybook.spring.domain.Review;
import umcstudybook.spring.domain.Store;
import umcstudybook.spring.web.dto.StoreRequestDTO;
import umcstudybook.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO.JoinStoreDTO request) {
        return Store.builder()
                .name(request.getName())
                .score(request.getScore())
                .address(request.getAddress())
                .build();
    }

    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store) {
        return StoreResponseDTO.JoinResultDTO.builder()
                .id(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Review review){
        return StoreResponseDTO.JoinResultDTO.builder()
                .id(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
