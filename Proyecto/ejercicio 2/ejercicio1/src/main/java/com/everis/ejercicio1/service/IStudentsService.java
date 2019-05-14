package com.everis.ejercicio1.service;

import java.util.List;
import java.util.Optional;

import com.everis.ejercicio1.models.Students;

public interface IStudentsService {
	
	Students registrar(Students students);
	
	Students modificar(Students students);

	void eliminar(int id);

	Optional<Students> listarId(int id);

	List<Students> listar();

}
