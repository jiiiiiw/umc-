package umcstudybook.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umcstudybook.spring.domain.Member;
import umcstudybook.spring.domain.Review;
import umcstudybook.spring.domain.Store;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findReviewsByStoreIsOrderByCreatedAtDesc(Pageable pageable, Store store);
    Page<Review> findReviewsByMemberIsOrderByCreatedAtDesc(Pageable pageable, Member member);
}
