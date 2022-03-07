package com.api.paymentapi.Model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_payment")
@Getter
@Setter
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Please, enter card number")
    private String cardNumber;

    @NotBlank(message = "Please, enter cvv number")
    private String cvv;

    @NotBlank(message = "Please, enter owner")
    private String owner;

    @NotBlank(message = "Please, enter experation date")
    private String expirationDate;

    @NotBlank(message = "Please, enter price")
    private BigDecimal price;

}
