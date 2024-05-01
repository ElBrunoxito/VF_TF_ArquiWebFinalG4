package com.grupo4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CiudadDto {
    private Integer id;
    private String nombreCiudad;
    private Integer paisId;
/*
    public CiudadDto(Integer id, String nombreCiudad) {
        this.id = id;
        this.nombreCiudad = nombreCiudad;
    }*/
/*
    public CiudadDto(Integer id, String nombreCiudad, Integer paisId) {
        this.id = id;
        this.nombreCiudad = nombreCiudad;
        this.paisId = paisId;
    }*/
}
