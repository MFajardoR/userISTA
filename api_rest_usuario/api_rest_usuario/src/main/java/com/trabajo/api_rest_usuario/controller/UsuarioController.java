/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trabajo.api_rest_usuario.controller;

import com.trabajo.api_rest_usuario.model.Usuario;
import com.trabajo.api_rest_usuario.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marco
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @PostMapping("/crear")
    public ResponseEntity<Usuario> Crear(@RequestBody Usuario usr) {
        
        if (usr.getNombre() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if (usr.getNombre().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(usuarioService.Crear(usr), HttpStatus.CREATED);
        }
    }
    
    @GetMapping("/lista")
    public ResponseEntity<List<Usuario>> Listar() {
        return new ResponseEntity<>(usuarioService.FindByAll(), HttpStatus.OK);
    }
    
    @GetMapping("/buscarNombre/{nombre}")
    public ResponseEntity<Usuario> BuscarNombre(@PathVariable String nombre) {

        List<Usuario> lis = usuarioService.FindByAll();
        for (Usuario usr : lis) {
            String name = usr.getNombre();
            if (name.equals(nombre)) {
                return new ResponseEntity<>(usuarioService.BuscarNombre(nombre), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping("/actualizar/{nombre}")
    public ResponseEntity<Usuario> Actualizar(@PathVariable String nombre, @RequestBody Usuario usr) {
        Usuario user = Buscarlist(nombre);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else if (user.getNombre().equals(usr.getNombre())) {
            user.setIdUsuario(user.getIdUsuario());
            user.setNombre(usr.getNombre());
            user.setClave(usr.getClave());
            user.setEmail(usr.getEmail());
            user.setEstado(usr.getEstado());
            return new ResponseEntity<>(usuarioService.Crear(user), HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    
    @DeleteMapping("/eliminar/{nombre}")
    public ResponseEntity<Usuario> Eliminar(@PathVariable String nombre) {
        Usuario usr = Buscarlist(nombre);

        if (usr == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
        usuarioService.Eliminar(nombre);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }  
    }
    
    public Usuario Buscarlist(String nombre) {
        return usuarioService.BuscarNombre(nombre);
    }
    
    
}
