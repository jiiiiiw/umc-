package umcstudybook.spring.service.review;

import umcstudybook.spring.domain.Review;
import umcstudybook.spring.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    Review join(ReviewRequestDTO.JoinReviewDTO request);
}
