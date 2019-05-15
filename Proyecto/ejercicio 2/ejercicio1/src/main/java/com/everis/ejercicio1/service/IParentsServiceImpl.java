package com.everis.ejercicio1.service;

import com.everis.ejercicio1.models.Parents;
import com.everis.ejercicio1.repository.IParentsRepo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IParentsServiceImpl implements IParentsService {

  @Autowired
  private IParentsRepo repo;

  @Override
  public Parents create(Parents parents) {
    return repo.save(parents);
  }

  @Override
  public Parents update(Parents parents) {
    return repo.save(parents);
  }

  @Override
  public void delete(int id) {
    repo.deleteById(id);
  }

  @Override
  public List<Parents> list() {
    return (List<Parents>) repo.findAll();
  }

  @Override
  public Optional<Parents> listId(int id) {
    return repo.findById(id);
  }

}
