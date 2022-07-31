/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.trabajo.api_rest_usuario.service;

import com.trabajo.api_rest_usuario.model.Usuario;
import java.util.List;

/**
 *
 * @author marco
 */
public interface UsuarioService {
     public Usuario Crear (Usuario  u);
    
    public List<Usuario> FindByAll();
    
    public Usuario BuscarNombre (String nombre);
    
    public void Eliminar(String nombre);
}

