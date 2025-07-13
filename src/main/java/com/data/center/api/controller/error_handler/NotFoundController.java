package com.data.center.api.controller.error_handler;

import com.data.center.api.models.response.error.BaseErrorResponse;
import com.data.center.api.models.response.error.ErrorResponse;
import com.data.center.util.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundController {

    @ExceptionHandler(NotFoundException.class)
    public BaseErrorResponse handlerNotFound(RuntimeException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.name())
                .code(HttpStatus.NOT_FOUND.value())
                .build();
    }
}
