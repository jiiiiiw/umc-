package umcstudybook.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umcstudybook.spring.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
