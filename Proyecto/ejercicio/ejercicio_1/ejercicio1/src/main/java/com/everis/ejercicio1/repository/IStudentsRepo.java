package com.everis.ejercicio1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.ejercicio1.models.Students;

public interface IStudentsRepo extends JpaRepository<Students, Integer>{

}
