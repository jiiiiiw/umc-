package umcstudybook.spring.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umcstudybook.spring.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;

    @Override
    public boolean isExist(Long id) {
        return memberRepository.existsById(id);
    }
}
