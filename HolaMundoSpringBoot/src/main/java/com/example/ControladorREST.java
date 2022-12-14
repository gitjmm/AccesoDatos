/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 * Mediante esta clase vamos a mandar un mensaje a la web: localhost:8090
 * @Slf4j. Nos permite escribir en los logs
 * @RestController
 * 
 */
@Slf4j
@RestController
public class ControladorREST {
    @GetMapping("/")
    public String comienzo(){
        log.info("Esto es un mensaje de log");
        return "Hola Spring";
    }
}
