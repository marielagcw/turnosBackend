package com.marielagcw.health_center.controller;

import com.marielagcw.health_center.util.ErrorMessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessageDTO> generalException(Exception e) {
        log.error("Error general del servidor", e);
        return ResponseEntity.status(500).body(new ErrorMessageDTO("Internal Server Error", "El pedido no pudo ser resuelto, intente nuevamente más tarde", 500));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorMessageDTO> notFoundElement(NoSuchElementException e) {
        log.error("No encontrado", e);
        return ResponseEntity.status(404).body(new ErrorMessageDTO("Not Found", "El elemento no pudo ser encontrado, verifique el parámetro ingresado e intente nuevamente", 404));
    }

}
