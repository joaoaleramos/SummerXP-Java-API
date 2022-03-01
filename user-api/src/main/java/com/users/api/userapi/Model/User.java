package com.users.api.userapi.Model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

  private UUID id;
  private String name;
  private String email;
  private String cpf;
  private String postalCode;
  private String address;

  public User() {

  }

}
