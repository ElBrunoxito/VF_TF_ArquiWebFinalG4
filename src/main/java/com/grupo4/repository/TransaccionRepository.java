package com.grupo4.repository;

import com.grupo4.models.TipoReserva;
import com.grupo4.models.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<Transaccion, Integer> {
}
