package com.grupo4.service;

import com.grupo4.dto.BancoDto;
import com.grupo4.dto.TipoReservaDto;
import com.grupo4.models.Banco;
import com.grupo4.models.TipoReserva;
import com.grupo4.repository.TipoReservaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoReservaService {
    final TipoReservaRepository tipoReservaRepository;

    public TipoReservaService(TipoReservaRepository tipoReservaRepository) {
        this.tipoReservaRepository = tipoReservaRepository;
    }

    public TipoReserva Add (TipoReservaDto tipoReservaDto) {
        TipoReserva tipoReserva = new TipoReserva(tipoReservaDto.getNombre());
        return tipoReservaRepository.save(tipoReserva);
    }
    public java.util.List<TipoReservaDto> getAll() {
         java.util.List<TipoReserva> lista = tipoReservaRepository.findAll();
         List<TipoReservaDto> listaDto = new ArrayList<>();
         TipoReservaDto item;
        for(TipoReserva tr: lista){
        item = new TipoReservaDto(tr.getId(),tr.getNombre());
        listaDto.add(item);
        }
         return listaDto;
}
}
