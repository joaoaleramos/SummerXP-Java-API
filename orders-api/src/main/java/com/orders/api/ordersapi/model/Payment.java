package com.orders.api.ordersapi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Please, enter card number")
    @Size(min = 13, max = 16, message = "Invalid card number")
    @Pattern(regexp = "^[0-9]*$", message = "Invalid card number")
    private String cardNumber;

    @NotBlank(message = "Please, enter cvv number")
    @Size(min = 3, max = 3, message = "Invalid cvv number")
    @Pattern(regexp = "^[0-9]*$", message = "Invalid cvv number")
    private String cvv;

    @NotBlank(message = "Please, enter owner")
    private String owner;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/yy")
    @Future(message = "Date must be valid")
    @NotBlank(message = "Please, enter experation date")
    private Date expirationDate;

    @NotNull(message = "Please, enter price")
    private BigDecimal price;
}
