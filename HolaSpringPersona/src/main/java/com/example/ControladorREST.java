/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import com.example.domain.Persona;
import java.util.Arrays;
import java.util.List;
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
    public List<Persona> comienzo(){
        Persona p = new Persona();
        p.setNombre("Juan");
        p.setApellido("Perez");
        p.setTelefono("11122223333");
        p.setEdad("30");
        //log.info("Esto es un mensaje de log");
        
        Persona p2 = new Persona();
        p2.setNombre("Juan");
        p2.setApellido("Perez");
        p2.setTelefono("11122223333");
        p2.setEdad("30"); 
        
        List<Persona> personas = Arrays.asList(p,p2);
        return personas;
    }
}
