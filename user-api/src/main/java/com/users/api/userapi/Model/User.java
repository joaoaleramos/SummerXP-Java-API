package com.users.api.userapi.Model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
@AllArgsConstructor

public class User implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonProperty
  private UUID id;

  @JsonProperty
  @NotBlank(message = "Please, enter name")
  private String name;

  @JsonProperty
  @Email(message = "Please, enter valid email")
  @NotBlank(message = "Please, enter email")
  private String email;

  @NotBlank(message = "Please, enter cpf")
  @CPF(message = "Please, enter a valid CPF")
  @JsonProperty
  private String cpf;

  @NotBlank(message = "Please, enter postal code")
  @JsonProperty
  private String postalCode;

  @NotBlank(message = "Please, enter address")
  @JsonProperty
  private String address;

  public User() {

  }

}
