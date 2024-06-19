package umcstudybook.spring.service.member;

import umcstudybook.spring.domain.Member;
import umcstudybook.spring.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    public Member joinMember(MemberRequestDTO.JoinDTO request);
}
