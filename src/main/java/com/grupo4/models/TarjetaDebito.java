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
    Usuario usuario;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "banco_id")
    private Banco banco;

    public TarjetaDebito(String numerotarjeta, Date fechaVencimiento, Integer cvv, Integer claveDigital, Banco banco) {
        this.numerotarjeta = numerotarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
        this.claveDigital = claveDigital;
        this.banco = banco;
    }
}
