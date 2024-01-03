package com.example.taskwizard.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

/**
 * Global Exception Handler.
 */
@Log4j2
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles global Exception when an exception is thrown.
     * @param ex {@link Exception}.
     * @return {@link ResponseEntity} with error message with http status 500 (INTERNAL_SERVER_ERROR).
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        log.log(Level.ERROR, "An exception occurred!", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
    }

    /**
     * Handles Exception when task is not found.
     * @param ex      {@link NoSuchElementException}.
     * @param request {@link HttpServletRequest}.
     * @return {@link ResponseEntity} with error message with http status 404 (NOT_FOUND).
     */
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex, HttpServletRequest request) {
        log.log(Level.WARN, ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found. Requested URL: " + request.getRequestURI());
    }

    /**
     * Handles Exception when request method is not supported.
     * @param ex      {@link HttpRequestMethodNotSupportedException}.
     * @param request {@link HttpServletRequest}.
     * @return {@link ResponseEntity} with error message with http status 405 (METHOD_NOT_ALLOWED).
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        log.log(Level.WARN, ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Request method: " + ex.getMethod() + " is not supported. Requested URL: " + request.getRequestURI());
    }

    /**
     * Handles IllegalArgumentException.
     * @param ex      {@link IllegalArgumentException}.
     * @param request {@link HttpServletRequest}.
     * @return {@link ResponseEntity} with error message with http status 400 (BAD_REQUEST).
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex, HttpServletRequest request) {
        log.log(Level.WARN, ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid argument: " + ex.getMessage() + ". Requested URL: " + request.getRequestURI());
    }

    /**
     * Handles NullPointerException.
     * @param ex      {@link NullPointerException}.
     * @param request {@link HttpServletRequest}.
     * @return {@link ResponseEntity} with error message with http status 500 (INTERNAL_SERVER_ERROR).
     */
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException ex, HttpServletRequest request) {
        log.log(Level.WARN, ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("NullPointerException occurred. Requested URL: " + request.getRequestURI());
    }
}