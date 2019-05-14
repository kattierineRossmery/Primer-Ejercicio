package com.everis.ejercicio1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@ApiModel("Model Families")
@Entity
@Getter
@Setter
@Table(name = "Families")
public class Families {

  @Id
  @NotNull
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ApiModelProperty(value = "the family member id", required = true)
  private int family_id;

  @NotNull
  @ApiModelProperty(value = "the family member name", required = true)
  private String family_name;

  @NotNull
  @ApiModelProperty(value = "the family member parent id", required = true)
  @ManyToOne
  @JoinColumn(name = "head_of_family_parent_id")
  private Parents parentsss;

  @JsonIgnore
  @OneToMany(mappedBy = "families")
  private List<FamilyMembers> listaFamilyMembers;

}
