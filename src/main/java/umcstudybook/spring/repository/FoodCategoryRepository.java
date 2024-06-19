package umcstudybook.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcstudybook.spring.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}