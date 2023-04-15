package com.starking.multitenancy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starking.multitenancy.models.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

}