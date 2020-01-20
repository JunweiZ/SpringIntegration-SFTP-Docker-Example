package com.example.springftp.controllers;

import com.example.springftp.domain.ErrorResponse;
import com.example.springftp.domain.FileNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.now;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlingController {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({FileNotFoundException.class})
    public ErrorResponse handleNotFoundException(RuntimeException ex) {

        log.info("Bad request : Requested data not found " + ex.getMessage());
        return new ErrorResponse(ex.getMessage());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            MethodArgumentTypeMismatchException.class})
    public ResponseEntity<List<ErrorResponse>> handleValidationException(MethodArgumentNotValidException ex) {

        log.info("Bad request : Validation error " + ex.getMessage());

        return new ResponseEntity<List<ErrorResponse>>(processError(ex), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGenericException(Exception ex) {

        log.error("Internal exception: ", ex);

        final String message = "Unexpected problem encountered. Please contact support team ( nizamiislamovs@gmail.com ) with timestamp ["
                + now() + "] and short description.";

        return new ErrorResponse(message);
    }

    private List<ErrorResponse> processError(MethodArgumentNotValidException ex) {
        List<ErrorResponse> errors = new ArrayList<>();

        ex.getBindingResult().getAllErrors()
                .forEach(err -> errors.add(new ErrorResponse(err.getDefaultMessage())));

        return errors;
    }
}
