package umcstudybook.spring.apiPayload.exception.handler;

import umcstudybook.spring.apiPayload.code.BaseErrorCode;
import umcstudybook.spring.apiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode code) {
        super(code);
    }
}
