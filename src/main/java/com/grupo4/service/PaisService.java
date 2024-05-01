package com.grupo4.service;

import com.grupo4.dto.PaisDto;
import com.grupo4.dto.TipoReservaDto;
import com.grupo4.models.Pais;
import com.grupo4.models.TipoReserva;
import com.grupo4.repository.PaisRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaisService {

    final PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public Pais Add (PaisDto paisDto) {
        Pais pais = new Pais(paisDto.getNombrePais());
        return paisRepository.save(pais);
    }

    /*public List<Pais> getAll() {
        return paisRepository.findAll();
    }*/

    public List<PaisDto> getAll() {
        List<Pais> lista = paisRepository.findAll();
        List<PaisDto> listaDto = new ArrayList<>();
        PaisDto item;
        for(Pais p: lista){
            item = new PaisDto(p.getId(),p.getNombrePais());
            listaDto.add(item);
        }
        return listaDto;
    }
}
