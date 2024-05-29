package umcstudybook.spring.service.Impl;

import org.springframework.stereotype.Service;
import umcstudybook.spring.apiPayload.code.status.ErrorStatus;
import umcstudybook.spring.apiPayload.exception.handler.TempHandler;
import umcstudybook.spring.service.TempQueryService;

@Service
public class TempQueryServiceImpl implements TempQueryService {
    @Override
    public void checkFlag(Integer flag) {
        if (flag == 1) {
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
        }
    }
}