package com.everis.ejercicio1.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "StudentParents")
public class StudentParents {
	
	
	  @EmbeddedId 
	  private StudentParentsPK pkLlave;
	  
	  @ManyToOne
	  @JoinColumn(name = "student_id", referencedColumnName = "student_id",
	  insertable = false, updatable = false) 
	  private Students student;
	  
	  @ManyToOne
	  @JoinColumn(name = "parent_id", referencedColumnName = "parent_id",
	  insertable = false, updatable = false) 
	  private Parents parent;

	
	 
}
