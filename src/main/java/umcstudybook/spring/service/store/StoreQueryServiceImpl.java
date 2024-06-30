package umcstudybook.spring.service.store;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umcstudybook.spring.apiPayload.code.status.ErrorStatus;
import umcstudybook.spring.apiPayload.exception.handler.StoreHandler;
import umcstudybook.spring.domain.Mission;
import umcstudybook.spring.domain.Review;
import umcstudybook.spring.domain.Store;
import umcstudybook.spring.repository.MissionRepository;
import umcstudybook.spring.repository.ReviewRepository;
import umcstudybook.spring.repository.StoreRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public boolean isExist(Long id) {
        return storeRepository.existsById(id);
    }

    @Override
    public Store getStore(Long id) {
        return storeRepository.findById(id).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
    }

    @Override
    public Page<Review> getReviews(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Pageable pageable = PageRequest.of(page, 10);
        return reviewRepository.findReviewsByStoreIsOrderByCreatedAtDesc(pageable, store);
    }

    @Override
    public Page<Mission> getMissions(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Pageable pageable = PageRequest.of(page, 10);
        return missionRepository.findMissionsByStoreIsOrderByCreatedAtDesc(pageable, store);
    }
}
