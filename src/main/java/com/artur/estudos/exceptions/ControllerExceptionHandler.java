package com.artur.estudos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundId.class)
    public ResponseEntity<StandardError> entityNotFoundId(EntityNotFoundId entityNotFoundId, HttpServletRequest request) {
        StandardError standardError = new StandardError();
        standardError.setTimestamp(Instant.now());
        standardError.setError("Id não encontrado");
        standardError.setStatus(HttpStatus.NOT_FOUND.value());
        standardError.setMessage(entityNotFoundId.getMessage());
        standardError.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(EntityMenorDeIdade.class)
    public ResponseEntity<StandardError> entityMenorDeIdade(EntityMenorDeIdade entityMenorDeIdade, HttpServletRequest request) {
        StandardError standardError = new StandardError();
        standardError.setTimestamp(Instant.now());
        standardError.setError("Idade inválida");
        standardError.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        standardError.setMessage(entityMenorDeIdade.getMessage());
        standardError.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(standardError);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> entityNomeeInvalido(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest request) {
        StandardError standardError = new StandardError();
        standardError.setTimestamp(Instant.now());

        Map<String, String> errosValidacao = new HashMap<>();

        methodArgumentNotValidException
                .getBindingResult()
                .getAllErrors()
                .forEach(objectError -> {
                    String campo = ((FieldError) objectError).getField();
                    String mensagemErro = objectError.getDefaultMessage();

                    errosValidacao.put(campo, mensagemErro);
                });

        standardError.setError("Erro de validação");
        standardError.setStatus(HttpStatus.BAD_REQUEST.value());
        standardError.setMessage(errosValidacao.toString());
        standardError.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }
}