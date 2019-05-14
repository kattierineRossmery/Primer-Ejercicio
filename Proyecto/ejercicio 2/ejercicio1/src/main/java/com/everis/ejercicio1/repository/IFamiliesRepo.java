package com.everis.ejercicio1.repository;

import com.everis.ejercicio1.models.Families;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFamiliesRepo extends JpaRepository<Families, Integer> {

}
