package com.example.mybatis;

public class PizzaToppings {
    private Long pizzaId;
    private Long toppingsId;

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

    @Override
    public String toString() {
        return "PizzaToppings{" +
                "pizzaId=" + pizzaId +
                ", toppingsId=" + toppingsId +
                '}';
    }
}
