package com.grupo4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BancoDto {
    private Integer id;
    private String nombreBanco;
    private String direccionBanco;
    private String telefonoBanco;
    private Integer bancoId;
}
