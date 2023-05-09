package br.com.ada.carro.controller;

import br.com.ada.carro.dto.ResultadoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.reflect.Field;

public class BaseController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultadoDTO handleValidException(MethodArgumentNotValidException ex) {
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        ex.getBindingResult().getAllErrors().forEach(e -> {
            String fieldName = ((FieldError)e).getField();
            String errorMessage = e.getDefaultMessage();
            resultadoDTO.putError(fieldName, errorMessage);
        });
        return resultadoDTO;
    }
}
