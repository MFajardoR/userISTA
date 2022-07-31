/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trabajo.api_rest_usuario.service;

import com.trabajo.api_rest_usuario.model.Usuario;
import com.trabajo.api_rest_usuario.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marco
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario Crear(Usuario u) {
        return usuarioRepository.save(u);
    }

    @Override
    public List<Usuario> FindByAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario BuscarNombre(String nombre) {
        return usuarioRepository.BuscarNombre(nombre);
    }

    @Override
    public void Eliminar(String nombre) {
        usuarioRepository.Eliminar(nombre);
    }
}
