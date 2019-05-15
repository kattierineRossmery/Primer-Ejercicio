package com.everis.ejercicio1.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;



@Embeddable
public class StudentParentsPK implements Serializable
{

	/**
	 * 
	 */
	
	  private static final long serialVersionUID = 1L;
	  
	  @Column(name = "student_id") 
	  private int student_cod;
	  
	  @Column(name = "parent_id") 
	  private int parent_cod;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + parent_cod;
		result = prime * result + student_cod;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentParentsPK other = (StudentParentsPK) obj;
		if (parent_cod != other.parent_cod)
			return false;
		if (student_cod != other.student_cod)
			return false;
		return true;
	}

	public int getStudent_cod() {
		return student_cod;
	}

	public void setStudent_cod(int student_cod) {
		this.student_cod = student_cod;
	}

	public int getParent_cod() {
		return parent_cod;
	}

	public void setParent_cod(int parent_cod) {
		this.parent_cod = parent_cod;
	}

	
	  
	 
}
