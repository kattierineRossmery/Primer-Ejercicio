package com.everis.ejercicio1.service;

import java.util.List;
import java.util.Optional;

import com.everis.ejercicio1.models.Families;

public interface IFamiliesService {
	
	Families registrar(Families families);

	Families modificar(Families families);

	void eliminar(int id);

	Optional<Families> listarId(int id);

	List<Families> listar();

}
