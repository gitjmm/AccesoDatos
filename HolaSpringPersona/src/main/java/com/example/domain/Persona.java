/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.domain;

import lombok.Data;

/**
 *
 * @author Usuario
 * @Data - Nos permite usar Lombok que es una librería que facilita getter/setter
 */
@Data
public class Persona {
    
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String edad;
}
