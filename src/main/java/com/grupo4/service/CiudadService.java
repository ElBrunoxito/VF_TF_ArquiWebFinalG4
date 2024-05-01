package com.grupo4.service;

import com.grupo4.dto.CiudadDto;
import com.grupo4.dto.PaisDto;
import com.grupo4.models.Ciudad;
import com.grupo4.models.Pais;
import com.grupo4.repository.CiudadRepository;
import com.grupo4.repository.PaisRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CiudadService {

    final CiudadRepository ciudadRepository;
    final PaisRepository paisRepository;
    public CiudadService(CiudadRepository ciudadRepository, PaisRepository paisRepository) {
        this.ciudadRepository = ciudadRepository;
        this.paisRepository = paisRepository;
    }

    public Ciudad Add (CiudadDto ciudadDto) {
        Pais pais = new Pais();
        pais.setId(ciudadDto.getPaisId());
        Ciudad ciudad = new Ciudad(ciudadDto.getNombreCiudad(),pais);
        return ciudadRepository.save(ciudad);
    }

    public java.util.List<CiudadDto> getAll() {
        java.util.List<Ciudad> lista = ciudadRepository.findAll();
        List<CiudadDto> listaDto = new ArrayList<>();
        CiudadDto item;
        for(Ciudad c: lista){
            item = new CiudadDto(c.getId(),c.getNombreCiudad(),c.getPais().getId());
            listaDto.add(item);
        }
        return listaDto;
    }
}
