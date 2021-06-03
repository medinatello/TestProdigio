package com.medinatello.testprodigio.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador usado para saber servicio activo
 */
@RestController
@RequestMapping("/api/ping")
@CrossOrigin(origins = "*")
public class PingController {

    private Logger logger = LoggerFactory.getLogger(PingController.class);

    @GetMapping("/")
    public ResponseEntity<String> ping(){
        logger.info("ping exitoso");
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }
}
