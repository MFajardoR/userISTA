/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.trabajo.api_rest_usuario.repository;

import com.trabajo.api_rest_usuario.model.Usuario;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author marco
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    @Query(value = "Select * from usuario usr where usr.nombre = :nombre", nativeQuery = true)
    public Usuario BuscarNombre(String nombre);
    
    @Modifying
     @Transactional
    @Query(value = "Delete from usuario where nombre = :nombre ", nativeQuery = true)
    public void Eliminar(String nombre);
}
