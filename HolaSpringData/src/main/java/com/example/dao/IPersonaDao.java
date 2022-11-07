/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.domain.Persona;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Usuario
 * CrudRepository. Interfaz que nos permite realizar operaciones CRUD 
 */

public interface IPersonaDao extends CrudRepository<Persona, Long>{
    
}
