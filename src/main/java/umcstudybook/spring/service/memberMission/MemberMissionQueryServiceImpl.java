package umcstudybook.spring.service.memberMission;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umcstudybook.spring.apiPayload.code.status.ErrorStatus;
import umcstudybook.spring.apiPayload.exception.handler.MemberHandler;
import umcstudybook.spring.domain.Member;
import umcstudybook.spring.domain.enums.MissionStatus;
import umcstudybook.spring.domain.mapping.MemberMission;
import umcstudybook.spring.repository.MemberMissionRepository;
import umcstudybook.spring.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService{

    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<MemberMission> findMissionByUserAndStatus(Long memberId, MissionStatus status, Integer page) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Pageable pageable = PageRequest.of(page, 10);
        return memberMissionRepository.findMemberMissionsByMemberIsAndStatusIsOrderByCreatedAtDesc(pageable, member, status);
    }
}