package com.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NonExistentEntityException.class)
    public ModelAndView nonExistanceEntityExceptionHandler(NonExistentEntityException ex) {
        ModelAndView response = new ModelAndView();
        response.addObject("status", ex.getStatus());
        response.addObject("errorCode", ex.getErrorCode());
        response.addObject("errorMessage", ex.getErrorMessage());
        return response;
    }
}
