package umcstudybook.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcstudybook.spring.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
