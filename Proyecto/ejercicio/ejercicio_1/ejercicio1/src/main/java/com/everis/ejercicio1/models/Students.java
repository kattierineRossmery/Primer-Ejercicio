package com.everis.ejercicio1.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("Model Students")
@Entity
@Data
@Table(name = "Students")
public class Students {

	@Id
	@NotNull
    @ApiModelProperty(value = "the student's id", required = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;

	@NotNull
    @ApiModelProperty(value = "the gender", required = true)
	private String gender;

	@NotNull
    @ApiModelProperty(value = "the student first name", required = true)
	private String first_name;

    @ApiModelProperty(value = "the student middle name", required = true)
	private String middle_name;

	@NotNull
    @ApiModelProperty(value = "the student's last name", required = true)
	private String last_name;

	@NotNull
	@Temporal(TemporalType.DATE)
    @ApiModelProperty(value = "the student's date of birth", required = true)
	private Date date_of_birth;

    @ApiModelProperty(value = "the student's details", required = true)
	private String other_student_details;
	
	@JsonIgnore
	@OneToMany(mappedBy = "students")
	private List<FamilyMembers> listaFamilyMembers;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student") 
	private List<StudentParents> StudentParents = new ArrayList<StudentParents>();
	 

}
