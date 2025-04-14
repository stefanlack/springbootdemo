package com.opitzconsulting.springbootdemo.common.error.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BackendErrorResponse {

    String message;
}
