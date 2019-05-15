package com.everis.ejercicio1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.ejercicio1.models.Families;
import com.everis.ejercicio1.repository.IFamiliesRepo;

@Service
public class IFamiliesServiceImpl implements IFamiliesService{
	
	@Autowired
	private IFamiliesRepo repo;

	@Override
	public Families registrar(Families families) {
		return repo.save(families);
	}

	@Override
	public Families modificar(Families families) {
		return repo.save(families);
	}

	@Override
	public void eliminar(int id) {
		repo.deleteById(id);		
	}

	@Override
	public Optional<Families> listarId(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Families> listar() {
		return repo.findAll();
	}

}
