package com.actividad.demo.services;

import com.actividad.demo.entitys.Usuario;
import com.actividad.demo.repositorys.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServicesImpl implements IUsuarioServices{
    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        // Verificar si el usuario ya existe
        if (usuarioRepository.findByUsername(usuario.getUsername()) != null) {
            throw new RuntimeException("El usuario ya existe");
        }
        return usuarioRepository.save(usuario);  // Guarda el usuario en la BD
    }

    /**
     * @return todos los usuarios existentes
     */
    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    /**
     * @param usuario
     * @return Se guardan usuarios nuevos en base de datos
     */
    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * @param id
     * @return se obtiene usuarios por su id
     */
    @Override
    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    /**
     * @param  id
     */
    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
