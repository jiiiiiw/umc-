package umcstudybook.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umcstudybook.spring.apiPayload.ApiResponse;
import umcstudybook.spring.converter.MemberMissionConverter;
import umcstudybook.spring.domain.mapping.MemberMission;
import umcstudybook.spring.service.memberMission.MemberMissionCommandService;
import umcstudybook.spring.web.dto.MemberMissionRequestDTO;
import umcstudybook.spring.web.dto.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/memberMissions")
public class MemberMissionController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MemberMissionResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberMissionRequestDTO.JoinMemberMissionDTO request) {
        MemberMission memberMission = memberMissionCommandService.joinMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toJoinResultDTO(memberMission));
    }
}
