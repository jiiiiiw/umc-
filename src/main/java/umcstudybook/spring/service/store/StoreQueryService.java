package umcstudybook.spring.service.store;

import org.springframework.data.domain.Page;
import umcstudybook.spring.domain.Mission;
import umcstudybook.spring.domain.Review;
import umcstudybook.spring.domain.Store;

public interface StoreQueryService {
    boolean isExist(Long id);
    Store getStore(Long id);
    Page<Review> getReviews(Long storeId, Integer page);
    Page<Mission> getMissions(Long storeId, Integer page);
}