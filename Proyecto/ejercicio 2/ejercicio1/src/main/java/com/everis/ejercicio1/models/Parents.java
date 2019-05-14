package com.everis.ejercicio1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@ApiModel("Model Parent")
@Entity
@Getter
@Setter
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

  @JsonIgnore
  @OneToMany(mappedBy = "parentsss")
  private List<Families> listaFamilias;

  @JsonIgnore
  @OneToMany(mappedBy = "parents")
  private List<FamilyMembers> listaFamilyMembers;

  @JsonIgnore
  @JoinTable(name = "studentsParents", joinColumns = @JoinColumn(name = "FK_Students", nullable = false), inverseJoinColumns = @JoinColumn(name = "FK_Parents", nullable = false))
  @ManyToMany(cascade = CascadeType.ALL)
  private List<Students> studiantes;

  public void addStudents(Students stud) {
    if (this.studiantes == null) {
      this.studiantes = new ArrayList<>();
    }

    this.studiantes.add(stud);
  }

}
