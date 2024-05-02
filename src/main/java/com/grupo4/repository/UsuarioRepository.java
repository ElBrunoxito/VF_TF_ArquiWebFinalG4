package com.grupo4.repository;

import com.grupo4.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
   // Usuario findByUsuario(String usuario);
   Optional<Usuario>  findByUsuario (String usuario);
}

