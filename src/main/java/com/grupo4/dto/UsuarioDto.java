package com.grupo4.dto;

import com.grupo4.models.Ciudad;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private String nombre;
    private String apellido;
    private String email;
    private String usuario;
    private String contrasena;
    private Date fechaRegistro;
    private String direccionUsuario;
    private String telefonoUsuario;
    private Integer ciudadId;
}
