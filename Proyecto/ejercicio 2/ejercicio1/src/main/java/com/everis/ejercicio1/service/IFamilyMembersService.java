package com.everis.ejercicio1.service;

import java.util.List;
import java.util.Optional;

import com.everis.ejercicio1.models.FamilyMembers;

public interface IFamilyMembersService {
	
	FamilyMembers registrar(FamilyMembers familyMembers);

	FamilyMembers modificar(FamilyMembers familyMembers);

	void eliminar(int id);

	Optional<FamilyMembers> listarId(int id);

	List<FamilyMembers> listar();

}
