package com.grupo4.repository;

import com.grupo4.models.Ciudad;
import com.grupo4.models.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {
}
