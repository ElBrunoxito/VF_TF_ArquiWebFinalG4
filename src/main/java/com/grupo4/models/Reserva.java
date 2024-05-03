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
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;
    private Date fechaCreacion;
    private Double monto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipoReserva_id")
    TipoReserva tipoReserva;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    Usuario usuario;

    public Reserva(String descripcion, Date fechaCreacion, Double monto, TipoReserva tipoReserva, Usuario usuario) {
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.monto = monto;
        this.tipoReserva = tipoReserva;
        this.usuario = usuario;
    }
}
