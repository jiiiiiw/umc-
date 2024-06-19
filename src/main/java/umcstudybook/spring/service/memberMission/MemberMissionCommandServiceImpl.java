package umcstudybook.spring.service.memberMission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umcstudybook.spring.apiPayload.code.status.ErrorStatus;
import umcstudybook.spring.apiPayload.exception.handler.MemberHandler;
import umcstudybook.spring.apiPayload.exception.handler.MissionHandler;
import umcstudybook.spring.converter.MemberMissionConverter;
import umcstudybook.spring.domain.Member;
import umcstudybook.spring.domain.Mission;
import umcstudybook.spring.domain.enums.MissionStatus;
import umcstudybook.spring.domain.mapping.MemberMission;
import umcstudybook.spring.repository.MemberMissionRepository;
import umcstudybook.spring.repository.MemberRepository;
import umcstudybook.spring.repository.MissionRepository;
import umcstudybook.spring.web.dto.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public MemberMission joinMemberMission(MemberMissionRequestDTO.JoinMemberMissionDTO request) {

        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() ->
                new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(request.getMissionId()).orElseThrow(() ->
                new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        MemberMission memberMission = MemberMissionConverter.toMemberMission(MissionStatus.CHALLENGING);
        memberMission.setMember(member);
        memberMission.setMission(mission);

        return memberMissionRepository.save(memberMission);
    }
}
