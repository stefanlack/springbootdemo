package com.opitzconsulting.springbootdemo.common.error.exceptions;

import org.springframework.http.HttpStatus;

public class DemoEntityNotFoundException extends SpringBootDemoException {
    private final String entitaet;
    private final Long id;

    public DemoEntityNotFoundException(String entitaet, Long id) {
        this.entitaet = entitaet;
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Entität " + entitaet + " mit ID " + id + " nicht gefunden.";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }


}
