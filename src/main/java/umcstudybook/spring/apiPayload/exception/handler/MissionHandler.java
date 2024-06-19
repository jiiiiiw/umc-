package umcstudybook.spring.apiPayload.exception.handler;

import umcstudybook.spring.apiPayload.code.BaseErrorCode;
import umcstudybook.spring.apiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {

    public MissionHandler(BaseErrorCode code) {
        super(code);
    }
}
