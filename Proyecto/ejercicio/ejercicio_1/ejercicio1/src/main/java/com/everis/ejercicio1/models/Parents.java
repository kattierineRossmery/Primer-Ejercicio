package com.everis.ejercicio1.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("Model Parent")
@Entity
@Data
@Table(name = "Parents")
public class Parents {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "the parent's id", required = true)
	private int parent_id;
	
	@NotNull
    @ApiModelProperty(value = "the gender", required = true)
	private String gender;
	
	@NotNull
    @ApiModelProperty(value = "the parent's first name", required = true)
	private String first_name;
	
    @ApiModelProperty(value = "the parent's middle name", required = true)
	private String middle_name;
	
    @ApiModelProperty(value = "the parent's last name", required = true)
	private String last_name;
	
    @ApiModelProperty(value = "the parent's details", required = true)
	private String other_parent_details;
	
	@OneToMany(mappedBy = "head_of_family_parent_id")
	private List<Families> listaFamilias;
	
	
	@OneToMany(mappedBy = "parents")
	private List<FamilyMembers> listaFamilyMembers;
	
	
	@OneToMany(mappedBy = "parent") 
	private List<StudentParents> StudentParents = new ArrayList<StudentParents>();
	 

}
