package umcstudybook.spring.apiPayload.exception.handler;

import umcstudybook.spring.apiPayload.code.BaseErrorCode;
import umcstudybook.spring.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode code) {
        super(code);
    }
}
