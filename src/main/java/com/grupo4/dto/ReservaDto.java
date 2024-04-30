package com.grupo4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDto {
    private Integer id;
    private String descripcion;
    private Date fechaCreacion;
    private Double Monto;
}
