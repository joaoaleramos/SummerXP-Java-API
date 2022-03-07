package com.orders.api.ordersapi.model;

import java.io.Serializable;
import java.util.UUID;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty
    private UUID id;

    @JsonProperty
    private String name;

    @JsonProperty
    private BigDecimal price;

}
