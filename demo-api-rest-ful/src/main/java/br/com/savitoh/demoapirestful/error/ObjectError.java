package br.com.savitoh.demoapirestful.error;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ObjectError {

    private final String message;
    private final String field;
    private final Object parameter;
}
