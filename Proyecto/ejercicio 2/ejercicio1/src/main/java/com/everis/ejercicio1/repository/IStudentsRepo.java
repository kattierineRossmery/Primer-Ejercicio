package com.everis.ejercicio1.repository;

import com.everis.ejercicio1.models.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentsRepo extends JpaRepository<Students, Integer> {

}
