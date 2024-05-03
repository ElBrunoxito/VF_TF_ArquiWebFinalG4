package com.grupo4.service;

import com.grupo4.dto.LoginDto;
import com.grupo4.dto.UsuarioDto;
import com.grupo4.models.AuthResponse;
import com.grupo4.models.Ciudad;
import com.grupo4.models.Role;
import com.grupo4.models.Usuario;
import com.grupo4.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginDto dto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsuario(), dto.getContrasena()));
        UserDetails userDetails=usuarioRepository.findByUsuario(dto.getUsuario()).orElseThrow();
        String token=jwtService.getToken(userDetails);
        return AuthResponse.builder()
                .token(token)
                .build();
    }
    public AuthResponse register(UsuarioDto usuarioDto) {
        Ciudad c = new Ciudad();
        c.setId(usuarioDto.getCiudadId());
        Usuario usuario = Usuario.builder()
                .nombre(usuarioDto.getNombre())
                .apellido(usuarioDto.getApellido())
                .email(usuarioDto.getEmail())
                .usuario(usuarioDto.getUsuario())
                .contrasena(passwordEncoder.encode( usuarioDto.getContrasena()))
                .fechaRegistro(usuarioDto.getFechaRegistro())
                .direccionUsuario(usuarioDto.getDireccionUsuario())
                .telefonoUsuario(usuarioDto.getTelefonoUsuario())
                .ciudad(c)
                .role(Role.USER)
                .build();
        usuarioRepository.save(usuario);
        return AuthResponse.builder()
                .token(jwtService.getToken(usuario))
                .build();
    }
}
