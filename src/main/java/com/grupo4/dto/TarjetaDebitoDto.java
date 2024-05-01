package com.grupo4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarjetaDebitoDto {
    private Integer id;
    private String numerotarjeta;
    private Date fechaVencimiento;
    private Integer cvv;
    private Integer claveDigital;
    private Integer bancoId;
}
