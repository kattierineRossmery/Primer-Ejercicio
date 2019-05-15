package com.everis.ejercicio1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.ejercicio1.models.FamilyMembers;
import com.everis.ejercicio1.repository.IFamilyMembersRepo;

@Service
public class IFamilyMembersServiceImpl implements IFamilyMembersService{

	@Autowired
	private IFamilyMembersRepo repo;

	@Override
	public FamilyMembers registrar(FamilyMembers familyMembers) {
		return repo.save(familyMembers);
	}

	@Override
	public FamilyMembers modificar(FamilyMembers familyMembers) {
		return repo.save(familyMembers);
	}

	@Override
	public void eliminar(int id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<FamilyMembers> listarId(int id) {
		return repo.findById(id);
	}

	@Override
	public List<FamilyMembers> listar() {
		return repo.findAll();
	}
	
	

}
