package com.grupo4.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombrePais;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "pais",cascade = CascadeType.ALL)
    List<Ciudad> ciudad ;

}
