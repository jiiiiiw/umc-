package umcstudybook.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umcstudybook.spring.apiPayload.ApiResponse;
import umcstudybook.spring.converter.MemberConverter;
import umcstudybook.spring.converter.MissionConverter;
import umcstudybook.spring.converter.ReviewConverter;
import umcstudybook.spring.domain.Member;
import umcstudybook.spring.domain.Review;
import umcstudybook.spring.domain.enums.MissionStatus;
import umcstudybook.spring.domain.mapping.MemberMission;
import umcstudybook.spring.service.member.MemberCommandService;
import umcstudybook.spring.service.member.MemberQueryService;
import umcstudybook.spring.service.memberMission.MemberMissionQueryService;
import umcstudybook.spring.validation.annotation.CheckPage;
import umcstudybook.spring.validation.annotation.ExistMember;
import umcstudybook.spring.web.dto.MemberRequestDTO;
import umcstudybook.spring.web.dto.MemberResponseDTO;
import umcstudybook.spring.web.dto.MissionResponseDTO;
import umcstudybook.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;
    private final MemberMissionQueryService memberMissionQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDTO request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "사용자의 리뷰를 찾는 API", description = "사용자의 ID를 Path variable로 전달하고 Request parameter로 page를 전달해주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "사용자 ID"),
            @Parameter(name = "page", description = "페이지 번호")
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviews(@ExistMember @PathVariable(name = "memberId") Long id,
                                                                          @CheckPage Integer page) {
        Page<Review> reviews = memberQueryService.getReviews(id, page);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviews));
    }

    @GetMapping("/{memberId}/missions")
    @Operation(summary = "사용자의 도전중인 미션 찾기", description = "사용자의 ID를 통해 도전중인 미션 반환")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "사용자 ID"),
            @Parameter(name = "page", description = "페이지 번호")
    })
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getChallengingMission(@ExistMember @PathVariable(name = "memberId") Long memberId,
                                                                                       @CheckPage Integer page) {
        Page<MemberMission> memberMissions = memberMissionQueryService.findMissionByUserAndStatus(memberId, MissionStatus.CHALLENGING, page);
        return ApiResponse.onSuccess(MissionConverter.missionPreViewListDTOByMemberMissions(memberMissions));
    }
}
