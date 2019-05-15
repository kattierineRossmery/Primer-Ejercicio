package com.everis.ejercicio1.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Data
@ApiModel("Model Family")
@Table(name = "FamilyMembers")
public class FamilyMembers {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "the family's id", required = true)
	private int family_member_id;
	
    @ApiModelProperty(value = "Parent or student", required = true)
	private String parent_or_student_members;
	
	@ManyToOne
    @ApiModelProperty(value = "the family's id", required = true)
	@JoinColumn(name = "family_id")
	private Families families;
	
	@ManyToOne
    @ApiModelProperty(value = "the parent's id", required = true)
	private Parents parents;
	
	@ManyToOne
    @ApiModelProperty(value = "the student's id", required = true)
	@JoinColumn(name = "student_id")
	private Students students;
	
	
	

}
