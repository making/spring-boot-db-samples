package com.example.doma;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Entity
public class PizzaToppings {
    @Id
    public Long pizzaId;
    @Id
    public Long toppingsId;
}
