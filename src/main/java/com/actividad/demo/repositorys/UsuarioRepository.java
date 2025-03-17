package com.actividad.demo.repositorys;

import com.actividad.demo.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
        Usuario findByUsername(String username);
}
