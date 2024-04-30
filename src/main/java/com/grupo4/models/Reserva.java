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
    private Double Monto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TipoReservaId")
    TipoReserva tipoReserva;
}
