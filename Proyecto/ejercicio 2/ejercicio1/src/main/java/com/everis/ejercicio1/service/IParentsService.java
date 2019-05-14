package com.everis.ejercicio1.service;

import java.util.List;
import java.util.Optional;

import com.everis.ejercicio1.models.Parents;

public interface IParentsService {

	Parents registrar(Parents parents);

	Parents modificar(Parents parents);

	void eliminar(int id);

	Optional<Parents> listarId(int id);

	List<Parents> listar();
}
