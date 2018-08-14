package pl.jeppesen.myapp.myapp.controller;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.jeppesen.myapp.myapp.exception.NotFoundException;
import pl.jeppesen.myapp.myapp.exception.ValidationException;


@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionMessage handleNotFoundException(NotFoundException e) {
        return new ExceptionMessage(e.getMessage());
    }


    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionMessage handleValidationException(ValidationException e) {
        return new ExceptionMessage(e.getMessage());
    }


    class ExceptionMessage {

        @Getter
        private String message;

        ExceptionMessage(String message) {
            this.message = message;
        }
    }
}
