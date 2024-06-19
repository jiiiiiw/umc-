package umcstudybook.spring.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umcstudybook.spring.apiPayload.code.status.ErrorStatus;
import umcstudybook.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umcstudybook.spring.converter.MemberConverter;
import umcstudybook.spring.domain.FoodCategory;
import umcstudybook.spring.domain.Member;
import umcstudybook.spring.domain.mapping.MemberPrefer;
import umcstudybook.spring.repository.FoodCategoryRepository;
import umcstudybook.spring.repository.MemberRepository;
import umcstudybook.spring.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService {
    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDTO request) {
        Member member = MemberConverter.toMember(request);

        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)))
                .collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberConverter.toMemberPreferList(foodCategoryList);
        memberPreferList.forEach(memberPrefer -> memberPrefer.setMember(member));
        return memberRepository.save(member);
    }
}
