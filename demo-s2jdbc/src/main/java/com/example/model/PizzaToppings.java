package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PizzaToppings {
    @Id
    private Long pizzaId;
    @Id
    private Long toppingsId;

    @ManyToOne
    private Pizza pizza;
    @ManyToOne
    private Topping toppings;

    public PizzaToppings(Long pizzaId, Long toppingsId) {
        this.pizzaId = pizzaId;
        this.toppingsId = toppingsId;
    }

    public PizzaToppings() {

    }

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

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Topping getToppings() {
        return toppings;
    }

    public void setToppings(Topping toppings) {
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "PizzaToppings{" +
                "pizzaId=" + pizzaId +
                ", toppingsId=" + toppingsId +
                '}';
    }
}
