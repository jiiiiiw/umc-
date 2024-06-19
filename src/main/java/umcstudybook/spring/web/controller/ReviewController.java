package umcstudybook.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umcstudybook.spring.apiPayload.ApiResponse;
import umcstudybook.spring.converter.ReviewConverter;
import umcstudybook.spring.domain.Review;
import umcstudybook.spring.service.review.ReviewCommandService;
import umcstudybook.spring.web.dto.ReviewRequestDTO;
import umcstudybook.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.JoinResultDTO> joinReview(@RequestBody @Valid ReviewRequestDTO.JoinReviewDTO request) {
        Review review = reviewCommandService.join(request);
        return ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review));
    }

}