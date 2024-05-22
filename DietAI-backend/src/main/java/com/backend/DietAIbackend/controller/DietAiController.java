package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.exception.ApiError;
import com.backend.DietAIbackend.exception.ServiceException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DietAiController {


    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApiError> handleUsernameNotFoundException(){
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(), "No existe el usuario");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ApiError> handleServiceException(ServiceException ex){
        ApiError apiError = new ApiError(ex.getHttpStatus(),ex.getHttpStatus().value(), ex.getMessage());
        return ResponseEntity.status(ex.getHttpStatus()).body(apiError);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiError> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String mensajePersonalizado = "Ha ocurrido un error de integridad de datos en la base de datos. " +
                "Por favor, revise los datos enviados.";

        // Aquí podrías extraer detalles específicos del error si es necesario.
        String detalle = ex.getMostSpecificCause().getMessage();

        ApiError apiError = new ApiError(
                HttpStatus.BAD_REQUEST,
                HttpStatus.BAD_REQUEST.value(),
                mensajePersonalizado
        );
        apiError.setDetalle(detalle);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }


}
