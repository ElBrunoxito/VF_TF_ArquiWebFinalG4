package com.grupo4.controller;

import com.grupo4.dto.BancoDto;
import com.grupo4.dto.TipoReservaDto;
import com.grupo4.models.TipoReserva;
import com.grupo4.service.TipoReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class TipoReservaController {
    final TipoReservaService tipoReservaService;

    public TipoReservaController(TipoReservaService tipoReservaService) {
        this.tipoReservaService = tipoReservaService;
    }

    @PostMapping("/admin/CrearTipoReserva")
    public ResponseEntity<TipoReserva> Add (@RequestBody TipoReservaDto tipoReservaDto) {
        return new ResponseEntity<>(tipoReservaService.Add(tipoReservaDto), HttpStatus.CREATED);
    }
    @GetMapping("/user/ListaTipoReserva")
    public ResponseEntity<List<TipoReservaDto>> getAll(){
        return new ResponseEntity<>(tipoReservaService.getAll(), HttpStatus.OK);
    }
}
