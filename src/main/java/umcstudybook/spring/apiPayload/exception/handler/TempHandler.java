package umcstudybook.spring.apiPayload.exception.handler;

import umcstudybook.spring.apiPayload.code.BaseErrorCode;
import umcstudybook.spring.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode code) {
        super(code);
    }
}
