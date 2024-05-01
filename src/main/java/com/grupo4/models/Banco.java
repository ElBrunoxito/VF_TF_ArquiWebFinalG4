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
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombreBanco;
    private String direccionBanco;
    private String telefonoBanco;
   /* @OneToMany(fetch = FetchType.LAZY, mappedBy = "banco", cascade = CascadeType.ALL)
    List<TarjetaDebito> tarjetas;
    //relacion ciudad-banco*/
   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;

    public Banco(String nombreBanco, String direccionBanco, String telefonoBanco, Ciudad ciudad) {
        this.nombreBanco = nombreBanco;
        this.direccionBanco = direccionBanco;
        this.telefonoBanco = telefonoBanco;
        this.ciudad = ciudad;
    }
}
