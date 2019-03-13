package br.com.savitoh.demoapirestful.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@AllArgsConstructor
@Getter
public class ErrorResponse {

    private final String message;
    private final int  codeStatus;
    private final String status;
    private final String objectName;
    private final List<ObjectError> errors;

}
