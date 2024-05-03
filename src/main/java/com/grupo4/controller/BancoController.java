package com.grupo4.controller;

import com.grupo4.dto.BancoDto;
import com.grupo4.dto.CiudadDto;
import com.grupo4.models.Banco;
import com.grupo4.models.Ciudad;
import com.grupo4.service.BancoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BancoController {
    final BancoService bancoService;

    public BancoController(BancoService bancoService) {
        this.bancoService = bancoService;
    }
    @PostMapping("/admin/CrearBanco")
    public ResponseEntity<Banco> Add (@RequestBody BancoDto bancoDto) {
        return new ResponseEntity<>(bancoService.Add(bancoDto), HttpStatus.CREATED);
    }

    @GetMapping("/user/ListaBanco")
    public ResponseEntity<List<BancoDto>> getAll(){
        return new ResponseEntity<>(bancoService.getAll(), HttpStatus.OK);
    }
}
