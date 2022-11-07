/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.domain;

import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author Usuario
 * @Data - Nos permite usar Lombok que es una librería que facilita getter/setter
 */
@Data
@Entity
@Table(name="persona")
public class Persona{
    @Id
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String edad;
}
