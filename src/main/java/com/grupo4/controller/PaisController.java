package com.grupo4.controller;

import com.grupo4.dto.PaisDto;
import com.grupo4.dto.TipoReservaDto;
import com.grupo4.models.Pais;
import com.grupo4.models.TipoReserva;
import com.grupo4.service.PaisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Pais")
public class PaisController {
    final PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @PostMapping("/Crear")
    public ResponseEntity<Pais> Add (@RequestBody PaisDto paisDto) {
        return new ResponseEntity<>(paisService.Add(paisDto), HttpStatus.CREATED);
    }

    @GetMapping("/Lista")
    public ResponseEntity<List<PaisDto>> getAll(){
        return new ResponseEntity<>(paisService.getAll(), HttpStatus.OK);
    }
}
