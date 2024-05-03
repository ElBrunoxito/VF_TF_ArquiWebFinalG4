package com.grupo4.controller;

import com.grupo4.dto.CiudadDto;
import com.grupo4.dto.ReservaDto;
import com.grupo4.models.Ciudad;
import com.grupo4.models.Reserva;
import com.grupo4.service.CiudadService;
import com.grupo4.service.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class ReservaController {

    final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping("/CrearReserva")
    public ResponseEntity<Reserva> Add (@RequestBody ReservaDto reservaDto) {
        return new ResponseEntity<>(reservaService.Add(reservaDto), HttpStatus.CREATED);
    }

    @GetMapping("/ListaReserva")
    public ResponseEntity<List<ReservaDto>> getAll(){
        return new ResponseEntity<>(reservaService.getAll(), HttpStatus.OK);
    }
}
