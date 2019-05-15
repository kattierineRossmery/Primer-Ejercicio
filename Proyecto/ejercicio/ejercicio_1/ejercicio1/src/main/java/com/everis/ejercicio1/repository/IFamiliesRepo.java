package com.everis.ejercicio1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.ejercicio1.models.Families;

public interface IFamiliesRepo extends JpaRepository<Families, Integer>{

}
