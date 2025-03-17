package com.actividad.demo.services;

import com.actividad.demo.entitys.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUsuarioServices {
    public Usuario crearUsuario(Usuario usuario);
    List<Usuario> obtenerTodos();
    Usuario guardarUsuario(Usuario usuario);
    Usuario obtenerPorId(Long id);
    void eliminarUsuario(Long id);
}
