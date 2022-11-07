/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import com.example.dao.IPersonaDao;
import com.example.domain.Persona;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 * Mediante esta clase vamos a mandar un mensaje a la web: localhost:8090
 * @Slf4j. Nos permite escribir en los logs de Spring
 * @RestController
 * 
 */
@Slf4j
@RestController
public class ControladorREST {
    @Autowired
    private IPersonaDao personaDao;
    
    @GetMapping("/")
    public String comienzo(){
        Iterable<Persona> persona = personaDao.findAll(); //Obtiene todos objetos persona
        return persona.toString();
       
    }
}
