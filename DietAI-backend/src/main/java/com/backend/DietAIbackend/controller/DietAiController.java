package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.exception.ApiError;
import com.backend.DietAIbackend.exception.ServiceException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Clase que se encarga de controlar las excepciones y mandar una respuesta
 * correcta que será gestionada por el front
 */
@RestControllerAdvice
public class DietAiController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Exception ex){
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return ResponseEntity.status(apiError.getCode()).body(apiError);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ApiError> handleServiceException(ServiceException ex){
        ApiError apiError = new ApiError(ex.getHttpStatus(),ex.getHttpStatus().value(), ex.getMessage());
        return ResponseEntity.status(ex.getHttpStatus()).body(apiError);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiError> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String mensajePersonalizado = "Ha ocurrido un error. Por favor, revise los datos.";

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
