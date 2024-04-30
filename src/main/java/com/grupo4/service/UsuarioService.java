package com.grupo4.service;

import com.grupo4.dto.LoginDto;
import com.grupo4.dto.UsuarioDto;
import com.grupo4.models.Ciudad;
import com.grupo4.models.Usuario;
import com.grupo4.repository.CiudadRepository;
import com.grupo4.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    final UsuarioRepository usuarioRepository;
    final CiudadRepository ciudadRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, CiudadRepository ciudadRepository) {
        this.usuarioRepository = usuarioRepository;
        this.ciudadRepository = ciudadRepository;
    }
    /*public Usuario Add(UsuarioDto usuarioDto){
        Usuario usuario = new Usuario();
        Ciudad ciudad = new Ciudad ();
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setApellido(usuarioDto.getApellido());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setUsuario(usuarioDto.getUsuario());
        usuario.setContrasena(usuarioDto.getContrasena());
        usuario.setFechaRegistro(usuarioDto.getFechaRegistro());
        usuario.setDireccionUsuario(usuarioDto.getDireccionUsuario());
        usuario.setTelefonoUsuario(usuarioDto.getTelefonoUsuario());
        //usuario.setSaldo(usuarioDto.getSaldo());
        ciudad.setId(usuarioDto.getCiudadId());
        usuario.setCiudad(ciudad);
        return usuarioRepository.save(usuario);
    }*/
    public Usuario Add(UsuarioDto usuarioDto){
       Ciudad ciudad = new Ciudad();
       ciudad.setId(usuarioDto.getCiudadId());
       Usuario usuario = new Usuario(usuarioDto.getNombre(), usuarioDto.getApellido(),
                usuarioDto.getEmail(), usuarioDto.getUsuario(), usuarioDto.getContrasena(),
                usuarioDto.getFechaRegistro(), usuarioDto.getDireccionUsuario(),usuarioDto.getTelefonoUsuario(), ciudad);
        return usuarioRepository.save(usuario);
    }
    public boolean autenticarUsuario(LoginDto loginDto) {
        // Buscar al usuario por nombre de usuario en la base de datos
        Usuario usuario = usuarioRepository.findByUsuario(loginDto.getUsuario());

        // Verificar si se encontró un usuario y si la contraseña coincide
        return usuario != null && usuario.getContrasena().equals(loginDto.getContrasena());
    }

}
