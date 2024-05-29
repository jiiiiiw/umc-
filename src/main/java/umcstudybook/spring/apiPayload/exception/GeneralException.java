package umcstudybook.spring.apiPayload.exception;

import lombok.AllArgsConstructor;
import umcstudybook.spring.apiPayload.code.BaseErrorCode;
import umcstudybook.spring.apiPayload.code.ErrorReasonDTO;

@AllArgsConstructor
public class GeneralException extends RuntimeException{

    private BaseErrorCode baseErrorCode;

    public ErrorReasonDTO getErrorReason() {
        return baseErrorCode.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return baseErrorCode.getReasonHttpStatus();
    }
}
