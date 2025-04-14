package com.opitzconsulting.springbootdemo.common.error.exceptions;

import org.springframework.http.HttpStatus;

public abstract class SpringBootDemoException extends RuntimeException {


    public abstract HttpStatus getHttpStatus();
}
