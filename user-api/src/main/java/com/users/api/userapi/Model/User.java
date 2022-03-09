package com.users.api.userapi.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @NotBlank(message = "Please, enter name")
  private String name;

  @Email(message = "Please, enter valid email")
  @NotBlank(message = "Please, enter email")
  private String email;

  @NotBlank(message = "Please, enter cpf")
  @CPF(message = "Please, enter a valid CPF")
  private String cpf;

  @NotBlank(message = "Please, enter postal code")
  private String postalCode;

  @NotBlank(message = "Please, enter address")
  private String address;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  @JsonFormat(pattern = "dd/MM/yy")
  @Past(message = "Date must be valid")
  private Date birthDate;

}
