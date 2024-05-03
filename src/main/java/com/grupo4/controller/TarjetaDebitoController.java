package com.grupo4.controller;

import com.grupo4.dto.TarjetaDebitoDto;
import com.grupo4.models.TarjetaDebito;
import com.grupo4.service.TarjetaDebitoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class TarjetaDebitoController {
    final TarjetaDebitoService tarjetaDebitoService;

    public TarjetaDebitoController(TarjetaDebitoService tarjetaDebitoService) {
        this.tarjetaDebitoService = tarjetaDebitoService;
    }
    @PostMapping("/CrearTarjetaDebito")
    public ResponseEntity<TarjetaDebito> Add (@RequestBody TarjetaDebitoDto TarjetaDebitoDto) {
        return new ResponseEntity<>(tarjetaDebitoService.Add(TarjetaDebitoDto), HttpStatus.CREATED);
    }

    @GetMapping("/ListaTarjetaDebito")
    public ResponseEntity<List<TarjetaDebitoDto>> getAll(){
        return new ResponseEntity<>(tarjetaDebitoService.getAll(), HttpStatus.OK);
    }
}
