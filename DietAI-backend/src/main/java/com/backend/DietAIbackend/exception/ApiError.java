package com.backend.DietAIbackend.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class ApiError {

    @NonNull
    private HttpStatus estado;

    @NonNull
    private int code;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime fecha = LocalDateTime.now();

    @NonNull
    private String message;

    private String detalle;
}
