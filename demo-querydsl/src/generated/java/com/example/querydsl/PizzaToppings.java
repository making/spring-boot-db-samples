package com.example.querydsl;

import javax.annotation.Generated;
import java.io.Serializable;

/**
 * PizzaToppings is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class PizzaToppings implements Serializable {

    private Long pizzaId;

    private Long toppingsId;

    public Long getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Long pizzaId) {
        this.pizzaId = pizzaId;
    }

    public Long getToppingsId() {
        return toppingsId;
    }

    public void setToppingsId(Long toppingsId) {
        this.toppingsId = toppingsId;
    }

    @Override
    public String toString() {
         return "pizzaId = " + pizzaId + ", toppingsId = " + toppingsId;
    }

}

