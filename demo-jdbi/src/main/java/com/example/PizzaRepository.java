package com.example;

import com.example.jdbi.PizzaDao;
import com.example.model.Base;
import com.example.model.Pizza;
import com.example.model.Topping;
import org.skife.jdbi.v2.Handle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PizzaRepository {
    private final PizzaDao pizzaDao;

    public PizzaRepository(Handle handle) {
        this.pizzaDao = handle.attach(PizzaDao.class);
    }

    public List<Pizza> findOrderByIdAsc() {
        return pizzaDao.findOrderByIdAsc().stream()
                .collect(Collectors.groupingBy(com.example.jdbi.Pizza::getId))
                .entrySet()
                .stream()
                .map(e -> {
                    com.example.jdbi.Pizza dto = e.getValue().get(0);
                    Pizza pizza = new Pizza();
                    pizza.setId(dto.getId());
                    pizza.setName(dto.getName());
                    pizza.setPrice(dto.getPrice());
                    Base base = new Base(dto.getId());
                    base.setName(dto.getBaseName());
                    pizza.setBase(base);
                    pizza.setToppings(e.getValue().stream()
                            .map(x -> {
                                Topping topping = new Topping(x.getToppingId());
                                topping.setName(x.getToppingName());
                                return topping;
                            })
                            .collect(Collectors.toList()));
                    return pizza;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public Pizza save(Pizza pizza) {
        long pizzaId = pizzaDao.insertPizza(pizza.getBase().getId(), pizza.getName(), pizza.getPrice());
        pizzaDao.insertPizzaToppings(pizzaId, pizza.getToppings().stream().map(Topping::getId).collect(Collectors.toList()));
        pizza.setId(pizzaId);
        return pizza;
    }
}
