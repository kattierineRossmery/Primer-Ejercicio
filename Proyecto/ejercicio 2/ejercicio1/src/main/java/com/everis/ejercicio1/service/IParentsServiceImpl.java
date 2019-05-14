package com.everis.ejercicio1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.ejercicio1.models.Parents;
import com.everis.ejercicio1.repository.IParentsRepo;

@Service
public class IParentsServiceImpl implements IParentsService{

	@Autowired
	private IParentsRepo repo;

	@Override
	public Parents registrar(Parents parents) {
		return repo.save(parents);
	}

	@Override
	public Parents modificar(Parents parents) {
		return repo.save(parents);
	}

	@Override
	public void eliminar(int id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Parents> listarId(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Parents> listar() {
		return repo.findAll();
	}

	

}
