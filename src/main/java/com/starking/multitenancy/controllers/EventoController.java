package com.starking.multitenancy.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starking.multitenancy.models.Evento;
import com.starking.multitenancy.repositories.EventoRepository;

@RestController
@RequestMapping("evento")
public class EventoController {

	private final EventoRepository eventoRepository;

	public EventoController(EventoRepository eventoRepository) {
		this.eventoRepository = eventoRepository;
	}

	@GetMapping
	public ResponseEntity<List<Evento>> getEventos() {
		List<Evento> eventos = eventoRepository.findAll();
		return ResponseEntity.ok(eventos);
	}
}