package com.pragma.users.infraestructure.input.advice;

import com.pragma.users.domain.exception.UserException;
import com.pragma.users.domain.utils.ErrorResponse;
import com.pragma.users.domain.utils.UtilConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorResponse> handleCategoryException(UserException userException) {
        ErrorResponse errorResponse = new ErrorResponse(userException.getErrorMessage(), userException.getErrorCode());
        return ResponseEntity.status(userException.getErrorCode()).body(errorResponse);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        StringBuilder errors = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String errorMessage = error.getDefaultMessage();
            errors.append(errorMessage).append(" ");
        });
        ErrorResponse errResponse = new ErrorResponse(errors.toString().trim(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errResponse);
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        String errorMessage = String.format(UtilConstant.INVALID_PARAMETER_VALUE, ex.getName(), ex.getMostSpecificCause().getMessage());
        ErrorResponse response = new ErrorResponse(errorMessage,HttpStatus.BAD_REQUEST.value() );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MissingServletRequestParameterException ex) {
        ErrorResponse errResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errResponse);
    }
}
