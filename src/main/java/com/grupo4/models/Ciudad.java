package com.grupo4.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombreCiudad;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "ciudad",cascade = CascadeType.ALL)
    List<Usuario> usuarios ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pais_id")
    Pais pais;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "ciudad",cascade = CascadeType.ALL)
    private List<Banco> bancos;

    public Ciudad(String nombreCiudad, Pais pais) {
        this.nombreCiudad = nombreCiudad;
        this.pais = pais;
    }
}
