package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avaje.ebean.EbeanServer;
import com.example.model.Pizza;

@Repository
public class PizzaRepository {
    
    @Autowired
    EbeanServer server;
    
    public List<Pizza> findOrderByIdAsc() {
        List<Pizza> pizzas = server.find(Pizza.class).orderBy("id asc").findList();
        return pizzas;
    }
    
    @Transactional
    public Pizza save(Pizza pizza) {
        server.save(pizza);
        return pizza;
    }
}
