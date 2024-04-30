package com.grupo4.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private String usuario;
    private String contrasena;
    private Date fechaRegistro = new Date();
    private String direccionUsuario;
    private String telefonoUsuario;
    private Double saldo;
    //realacion 1-1 usuario-TD
   /* @OneToOne(mappedBy = "usuario" ,cascade = CascadeType.ALL)
    private TarjetaDebito tarjetaDebito;*/
    //relación usuario-ciudad
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ciudad_id")
    Ciudad ciudad;

   /* public Usuario(String nombre, String apellido, String email, String usuario, String contrasena, Date fechaRegistro, String direccionUsuario, String telefonoUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.fechaRegistro = fechaRegistro;
        this.direccionUsuario = direccionUsuario;
        this.telefonoUsuario = telefonoUsuario;
    }*/

}
