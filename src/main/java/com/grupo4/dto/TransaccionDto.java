package com.grupo4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransaccionDto {
    private Integer id;
    private Date fecha;
    private Double monto;
}
