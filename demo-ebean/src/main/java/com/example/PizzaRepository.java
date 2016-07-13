package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.TxRunnable;
import com.example.model.Pizza;

@Repository
public class PizzaRepository {
    
    @Autowired
    EbeanServer server;
    
    public List<Pizza> findOrderByIdAsc() {
        List<Pizza> pizzas = server.find(Pizza.class).orderBy("ID ASC").findList();
        return pizzas;
    }
    
    public Pizza save(Pizza pizza) {
        server.execute(new TxRunnable() {
            @Override
            public void run() {
                server.save(pizza);
            }
        });
        return pizza;
    }
}
