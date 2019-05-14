package com.everis.ejercicio1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.ejercicio1.models.Students;
import com.everis.ejercicio1.repository.IStudentsRepo;

@Service
public class IStudentsServiceImpl implements IStudentsService{
	
	@Autowired
	private IStudentsRepo repo;

	@Override
	public Students registrar(Students students) {
		return repo.save(students);
	}

	@Override
	public Students modificar(Students students) {
		return repo.save(students);
	}

	@Override
	public void eliminar(int id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Students> listarId(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Students> listar() {
		return repo.findAll();
	}

}
