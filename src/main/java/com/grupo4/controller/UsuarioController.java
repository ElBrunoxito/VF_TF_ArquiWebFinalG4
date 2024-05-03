package com.grupo4.controller;

import com.grupo4.dto.LoginDto;
import com.grupo4.dto.UsuarioDto;
import com.grupo4.models.AuthResponse;
import com.grupo4.models.Usuario;
import com.grupo4.service.AuthService;
import com.grupo4.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

    private final AuthService authService;
    final UsuarioService usuarioService;

    public UsuarioController(AuthService authService, UsuarioService usuarioService) {
        this.authService = authService;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login (@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(authService.login(loginDto));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> bienvenido (@RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.ok(authService.register(usuarioDto));}
/*
    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginRequestDto) {
        boolean autenticado = usuarioService.autenticarUsuario(loginRequestDto);

        if (autenticado) {
            return "Inicio de sesión exitoso";
        } else {
            return "Credenciales incorrectas";
        }
    }
    @PostMapping("/Registrar")
    public ResponseEntity<Usuario> Add(@RequestBody UsuarioDto usuarioDto){
        return new ResponseEntity<>(usuarioService.Add(usuarioDto), HttpStatus.CREATED);
    }

 */
}
