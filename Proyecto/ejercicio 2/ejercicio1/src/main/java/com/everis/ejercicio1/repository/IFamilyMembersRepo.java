package com.everis.ejercicio1.repository;

import com.everis.ejercicio1.models.FamilyMembers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFamilyMembersRepo extends JpaRepository<FamilyMembers, Integer> {

}
