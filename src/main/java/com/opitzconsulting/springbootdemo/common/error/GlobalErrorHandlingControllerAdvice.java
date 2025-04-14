package com.opitzconsulting.springbootdemo.common.error;

import com.opitzconsulting.springbootdemo.common.error.exceptions.SpringBootDemoException;
import com.opitzconsulting.springbootdemo.common.error.response.BackendErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class GlobalErrorHandlingControllerAdvice {


    @ExceptionHandler(SpringBootDemoException.class)
    ResponseEntity<BackendErrorResponse> onSpringBootDemoException(SpringBootDemoException springBootDemoException) {

        log.error(springBootDemoException.getMessage(), springBootDemoException);

        return ResponseEntity.status(springBootDemoException.getHttpStatus())
                .body(new BackendErrorResponse(springBootDemoException.getMessage()));

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<BackendErrorResponse> onRuntimeException(RuntimeException runtimeException) {

        log.error(runtimeException.getMessage(), runtimeException);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new BackendErrorResponse("Ein unerwarteter Fehler ist aufgetreten. Bitte kontaktieren Sie den Administrator."));

    }
}
