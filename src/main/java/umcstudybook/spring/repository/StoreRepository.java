package umcstudybook.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcstudybook.spring.domain.Store;

public interface StoreRepository extends JpaRepository<Store,Long> {
}