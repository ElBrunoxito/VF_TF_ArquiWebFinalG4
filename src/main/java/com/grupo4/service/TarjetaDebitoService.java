package com.grupo4.service;

import com.grupo4.dto.CiudadDto;
import com.grupo4.dto.TarjetaDebitoDto;
import com.grupo4.models.Banco;
import com.grupo4.models.Ciudad;
import com.grupo4.models.Pais;
import com.grupo4.models.TarjetaDebito;
import com.grupo4.repository.BancoRepository;
import com.grupo4.repository.TarjetaDebitoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarjetaDebitoService {
    final TarjetaDebitoRepository tarjetaDebitoRepository;
    final BancoRepository bancoRepository;
    public TarjetaDebitoService(TarjetaDebitoRepository tarjetaDebitoRepository, BancoRepository bancoRepository) {
        this.tarjetaDebitoRepository = tarjetaDebitoRepository;
        this.bancoRepository = bancoRepository;
    }

    public TarjetaDebito Add (TarjetaDebitoDto tarjetaDebitoDto) {
        Banco banco = new Banco();
        banco.setId(tarjetaDebitoDto.getBancoId());
        TarjetaDebito tarjetaDebito = new TarjetaDebito(tarjetaDebitoDto.getNumerotarjeta(),tarjetaDebitoDto.getFechaVencimiento(),tarjetaDebitoDto.getCvv(),
                tarjetaDebitoDto.getClaveDigital(),banco);
        return tarjetaDebitoRepository.save(tarjetaDebito);
    }

    public java.util.List<TarjetaDebitoDto> getAll() {
        java.util.List<TarjetaDebito> lista = tarjetaDebitoRepository.findAll();
        List<TarjetaDebitoDto> listaDto = new ArrayList<>();
        TarjetaDebitoDto item;
        for(TarjetaDebito td: lista){
            item = new TarjetaDebitoDto(td.getId(),td.getNumerotarjeta(),td.getFechaVencimiento(),td.getCvv(),td.getClaveDigital(),td.getBanco().getId());
            listaDto.add(item);
        }
        return listaDto;
    }
}
