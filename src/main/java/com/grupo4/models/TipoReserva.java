package com.grupo4.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tipoReserva",cascade = CascadeType.ALL)
    List<Reserva> reservas ;

    public TipoReserva(String nombre) {
    }
}
