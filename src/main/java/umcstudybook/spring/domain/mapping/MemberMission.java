package umcstudybook.spring.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umcstudybook.spring.domain.Member;
import umcstudybook.spring.domain.Mission;
import umcstudybook.spring.domain.common.BaseEntity;
import umcstudybook.spring.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public void setMember(Member member) {
        this.member = member;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }
}