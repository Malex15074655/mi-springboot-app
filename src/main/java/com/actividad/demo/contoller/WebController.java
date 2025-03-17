package com.actividad.demo.contoller;

import com.actividad.demo.entitys.Usuario;
import com.actividad.demo.services.IUsuarioServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class WebController {

    private final IUsuarioServices usuarioServices;
    // Página principal con la lista de usuarios
    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioServices.obtenerTodos()); // Lista de usuarios
        return "home"; // Carga la plantilla Thymeleaf home.html
    }

    // Agregar usuario desde el formulario
    @PostMapping("/agregar")
    public String agregarUsuario(@RequestParam String nombre, @RequestParam String email, @RequestParam String contrasenna) {
        Usuario usuario = new Usuario();
        usuario.setUsername(nombre);
        usuario.setEmail(email);
        usuario.setPassword(contrasenna);
        usuarioServices.guardarUsuario(usuario);
        return "redirect:/home"; // Redirige al listado de usuarios
    }

    // Eliminar usuario
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioServices.eliminarUsuario(id);
        return "redirect:/home"; // Redirige al listado de usuarios
    }
}
