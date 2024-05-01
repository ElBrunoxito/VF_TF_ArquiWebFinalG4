package com.grupo4.service;

import com.grupo4.dto.BancoDto;
import com.grupo4.dto.CiudadDto;
import com.grupo4.models.Banco;
import com.grupo4.models.Ciudad;
import com.grupo4.repository.BancoRepository;
import com.grupo4.repository.CiudadRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BancoService {
    final BancoRepository bancoRepository;
    final CiudadRepository ciudadRepository;
    public BancoService(BancoRepository bancoRepository, CiudadRepository ciudadRepository) {
        this.bancoRepository = bancoRepository;
        this.ciudadRepository = ciudadRepository;
    }
    public Banco Add (BancoDto bancoDto) {
        Ciudad ciudad = new Ciudad();
        ciudad.setId(bancoDto.getCiudadId());
        Banco banco = new Banco(bancoDto.getNombreBanco(),bancoDto.getDireccionBanco(),bancoDto.getTelefonoBanco(),ciudad);
        return bancoRepository.save(banco);
    }

    public java.util.List<BancoDto> getAll() {
        java.util.List<Banco> lista = bancoRepository.findAll();
        List<BancoDto> listaDto = new ArrayList<>();
        BancoDto item;
        for(Banco b: lista){
            item = new BancoDto(b.getId(),b.getNombreBanco(),b.getDireccionBanco(),b.getTelefonoBanco(),b.getCiudad().getId());
            listaDto.add(item);
        }
        return listaDto;
    }
}
