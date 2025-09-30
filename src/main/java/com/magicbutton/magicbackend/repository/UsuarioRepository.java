package com.magicbutton.magicbackend.repository;

import com.magicbutton.magicbackend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    //CRUD
  boolean existsByCorreo(String correo);
 Optional<Usuario>findByCorreo(String correo);
}
