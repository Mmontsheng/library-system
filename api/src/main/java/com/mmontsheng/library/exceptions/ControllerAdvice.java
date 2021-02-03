package com.mmontsheng.library.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmontsheng.library.dto.BaseResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ResponseBody
    @ExceptionHandler(value = DefaultException.class)
    public ResponseEntity<BaseResponse> genericException(DefaultException exception) {
        BaseResponse response = BaseResponse.builder().message(exception.getMessage()).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseEntity<BaseResponse> jsonParseException(Exception e) {
        log.error("JSON Parse exception: {}", e);
        BaseResponse response = BaseResponse.builder().message("An error occured while reading request").build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<BaseResponse> incorrectParameter(MethodArgumentNotValidException exception) {

        String message = exception.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        BaseResponse response = BaseResponse.builder().message(message).build();

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
    }
}
