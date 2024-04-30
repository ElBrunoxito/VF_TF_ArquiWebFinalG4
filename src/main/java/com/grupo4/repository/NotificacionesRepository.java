package com.grupo4.repository;

import com.grupo4.models.Notificaciones;
import com.grupo4.models.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacionesRepository extends JpaRepository<Notificaciones, Integer> {
}
