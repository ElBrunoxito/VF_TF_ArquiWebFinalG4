package com.grupo4.controller;

import com.grupo4.dto.UsuarioDto;
import com.grupo4.models.Usuario;
import com.grupo4.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping("/Registrar")
    public ResponseEntity<Usuario> Add(@RequestBody UsuarioDto usuarioDto){
        return new ResponseEntity<>(usuarioService.Add(usuarioDto), HttpStatus.CREATED);
    }
}
