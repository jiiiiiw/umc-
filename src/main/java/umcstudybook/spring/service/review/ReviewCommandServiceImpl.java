package umcstudybook.spring.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umcstudybook.spring.apiPayload.code.status.ErrorStatus;
import umcstudybook.spring.apiPayload.exception.handler.MemberHandler;
import umcstudybook.spring.apiPayload.exception.handler.StoreHandler;
import umcstudybook.spring.converter.ReviewConverter;
import umcstudybook.spring.domain.Member;
import umcstudybook.spring.domain.Review;
import umcstudybook.spring.domain.Store;
import umcstudybook.spring.repository.MemberRepository;
import umcstudybook.spring.repository.ReviewRepository;
import umcstudybook.spring.repository.StoreRepository;
import umcstudybook.spring.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review join(ReviewRequestDTO.JoinReviewDTO request) {
        Review review = ReviewConverter.toReview(request);

        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() ->
                new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(() ->
                new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        review.setMember(member);
        review.setStore(store);
        updateScoreOfStore(store, review);

        return reviewRepository.save(review);
    }

    private void updateScoreOfStore(Store store, Review review) {
        if (store.getReviewList().isEmpty()) {
            store.updateScore(review.getScore());
        }
        else {
            float total = store.getScore() * store.getReviewList().size() + review.getScore();
            store.updateScore(total / (store.getReviewList().size() + 1));
        }
    }
}