package com.example;

import com.example.model.Pizza;
import com.example.model.PizzaToppings;
import com.example.model.Topping;
import org.seasar.extension.jdbc.JdbcManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PizzaRepository {
    private final JdbcManager jdbcManager;

    public PizzaRepository(JdbcManager jdbcManager) {
        this.jdbcManager = jdbcManager;
    }

    public List<Pizza> findOrderByIdAsc() {
        return jdbcManager.from(Pizza.class)
                .innerJoin("base")
                .innerJoin("pizzaToppings")
                .innerJoin("pizzaToppings.toppings")
                .getResultList()
                .stream()
                .map(p -> {
                    p.setToppings(p.getPizzaToppings().stream()
                            .map(pt -> {
                                Topping t = new Topping(pt.getToppingsId());
                                t.setName(pt.getToppings().getName());
                                return t;
                            })
                            .collect(Collectors.toList()));
                    return p;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public Pizza save(Pizza pizza) {
        pizza.setBaseId(pizza.getBase().getId());
        jdbcManager.insert(pizza).execute();
        jdbcManager.insertBatch(pizza.getToppings().stream().map(t -> new PizzaToppings(pizza.getId(), t.getId())).collect(Collectors.toList())).execute();
        return pizza;
    }
}
