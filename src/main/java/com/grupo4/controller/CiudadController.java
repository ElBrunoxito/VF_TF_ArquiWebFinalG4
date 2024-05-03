package com.grupo4.controller;

import com.grupo4.dto.CiudadDto;
import com.grupo4.dto.PaisDto;
import com.grupo4.models.Ciudad;
import com.grupo4.models.Pais;
import com.grupo4.service.CiudadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class CiudadController {
    final CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }
    @PostMapping("/Crear")
    public ResponseEntity<Ciudad> Add (@RequestBody CiudadDto ciudadDto) {
        return new ResponseEntity<>(ciudadService.Add(ciudadDto), HttpStatus.CREATED);
    }

    @GetMapping("/Lista")
    public ResponseEntity<List<CiudadDto>> getAll(){
        return new ResponseEntity<>(ciudadService.getAll(), HttpStatus.OK);
    }
}
