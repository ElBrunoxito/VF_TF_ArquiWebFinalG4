package com.grupo4.service;

import com.grupo4.dto.CiudadDto;
import com.grupo4.dto.ReservaDto;
import com.grupo4.models.*;
import com.grupo4.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService {

    final ReservaRepository reservaRepository;
    final UsuarioRepository usuarioRepository;
    final TipoReservaRepository tipoReservaRepository;

    public ReservaService(ReservaRepository reservaRepository, UsuarioRepository usuarioRepository, TipoReservaRepository tipoReservaRepository) {
        this.reservaRepository = reservaRepository;
        this.usuarioRepository = usuarioRepository;
        this.tipoReservaRepository = tipoReservaRepository;
    }

    public Reserva Add (ReservaDto reservaDto) {
        TipoReserva tipoReserva = new TipoReserva();
        tipoReserva.setId(reservaDto.getTipoReservaId());
        Usuario usuario = new Usuario();
        usuario.setId(reservaDto.getUsuarioId());
        usuario.setRole(Role.USER);
        Reserva reserva = new Reserva(reservaDto.getDescripcion(),reservaDto.getFechaCreacion(),reservaDto.getMonto(),tipoReserva,usuario);
        return reservaRepository.save(reserva);
    }

    public java.util.List<ReservaDto> getAll() {
        java.util.List<Reserva> lista = reservaRepository.findAll();
        List<ReservaDto> listaDto = new ArrayList<>();
        ReservaDto item;
        for(Reserva r: lista){
            item = new ReservaDto(r.getId(),r.getDescripcion(),r.getFechaCreacion(),r.getMonto(),r.getTipoReserva().getId(),r.getUsuario().getId());
            listaDto.add(item);
        }
        return listaDto;
    }
}
