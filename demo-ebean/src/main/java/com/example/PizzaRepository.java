package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.Pizza;

@Repository
public class PizzaRepository {
    
    public List<Pizza> findOrderByIdAsc() {
        List<Pizza> pizzas = new ArrayList<>();
        return pizzas;
    }
    
    public Pizza save(Pizza pizza) {
        return pizza;
    }
}
