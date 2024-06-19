package umcstudybook.spring.service.store;

import umcstudybook.spring.domain.Store;
import umcstudybook.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Store joinStore(StoreRequestDTO.JoinStoreDTO request);
}