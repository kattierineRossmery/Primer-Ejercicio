package com.everis.ejercicio1.service;

import com.everis.ejercicio1.models.FamilyMembers;
import com.everis.ejercicio1.repository.IFamilyMembersRepo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IFamilyMembersServiceImpl implements IFamilyMembersService {

  @Autowired
  private IFamilyMembersRepo repo;

  @Override
  public FamilyMembers create(FamilyMembers familyMembers) {
    return repo.save(familyMembers);
  }

  @Override
  public FamilyMembers update(FamilyMembers familyMembers) {
    return repo.save(familyMembers);
  }

  @Override
  public void delete(int id) {
    repo.deleteById(id);
  }

  @Override
  public Optional<FamilyMembers> listId(int id) {
    return repo.findById(id);
  }

  @Override
  public List<FamilyMembers> list() {
    return (List<FamilyMembers>) repo.findAll();
  }

}
