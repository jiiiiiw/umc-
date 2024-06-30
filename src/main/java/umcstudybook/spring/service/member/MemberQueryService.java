package umcstudybook.spring.service.member;

import org.springframework.data.domain.Page;
import umcstudybook.spring.domain.Review;

public interface MemberQueryService {
    boolean isExist(Long id);
    Page<Review> getReviews(Long memberId, Integer page);
}
