package umcstudybook.spring.service.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umcstudybook.spring.apiPayload.code.status.ErrorStatus;
import umcstudybook.spring.apiPayload.exception.handler.RegionHandler;
import umcstudybook.spring.converter.StoreConverter;
import umcstudybook.spring.domain.Region;
import umcstudybook.spring.domain.Store;
import umcstudybook.spring.repository.RegionRepository;
import umcstudybook.spring.repository.StoreRepository;
import umcstudybook.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store joinStore(StoreRequestDTO.JoinStoreDTO request) {
        Store store = StoreConverter.toStore(request);

        Region region = regionRepository.findById(request.getRegionId()).orElseThrow(() ->
                new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        store.setRegion(region);

        return storeRepository.save(store);
    }
}
