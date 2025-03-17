package com.actividad.demo.contoller;

import com.actividad.demo.entitys.Usuario;
import com.actividad.demo.services.IUsuarioServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    private final IUsuarioServices usuarioServices;

    @PostMapping("/crear")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioServices.crearUsuario(usuario);
    }

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioServices.obtenerTodos();
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public Usuario obtenerUsuario(@PathVariable Long id) {
        return usuarioServices.obtenerPorId(id);
    }

    // Guardar un nuevo usuario
    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioServices.guardarUsuario(usuario);
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioServices.eliminarUsuario(id);
    }
}
