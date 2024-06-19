package umcstudybook.spring.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umcstudybook.spring.repository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService{

    private final MissionRepository missionRepository;

    @Override
    public boolean isExist(Long id) {
        return missionRepository.existsById(id);
    }
}
