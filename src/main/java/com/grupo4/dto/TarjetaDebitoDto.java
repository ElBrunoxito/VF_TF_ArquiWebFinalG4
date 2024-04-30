package com.grupo4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarjetaDebitoDto {
    private Integer id;
    private String numerotarjeta;
    private Integer usuarioId;
}
