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
public class TarjetaDebito {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer Id;
    private String numerotarjeta;
    private Date fechaVencimiento;
    private Integer cvv;
    private Integer claveDigital;
    //relacion 1-1 usuario-TD
   /* @OneToOne
    @JoinColumn(name = "usuario_id")
    Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "banco_id",nullable = false)
    private Banco banco;


   public TarjetaDebito(String numerotarjeta, Usuario usuario) {
        this.numerotarjeta = numerotarjeta;
        this.usuario = usuario;
    }*/
}
