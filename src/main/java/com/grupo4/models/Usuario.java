package com.grupo4.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table( uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario"})})
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic
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
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "usuario",cascade = CascadeType.ALL)
    List<Reserva> reservas ;
    @Enumerated(EnumType.STRING)
    Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return usuario;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
