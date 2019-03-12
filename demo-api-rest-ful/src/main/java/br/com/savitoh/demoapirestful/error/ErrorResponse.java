package br.com.savitoh.demoapirestful.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
public class ErrorResponse {

    private final int  codeStatus;
    private final String string;
    private final String message;
    private final List<String> errors;

}
