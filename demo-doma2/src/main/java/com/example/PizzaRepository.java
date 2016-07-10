package com.example;

import com.example.doma.PizzaDao;
import com.example.doma.PizzaToppings;
import com.example.model.Base;
import com.example.model.Pizza;
import com.example.model.Topping;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PizzaRepository {

    private final PizzaDao pizzaDao;

    public PizzaRepository(PizzaDao pizzaDao) {
        this.pizzaDao = pizzaDao;
    }

    public List<Pizza> findOrderByIdAsc() {
        return pizzaDao.findOrderByIdAsc().stream()
                .collect(Collectors.groupingBy(x -> x.id))
                .entrySet()
                .stream()
                .map(e -> {
                    com.example.doma.Pizza dto = e.getValue().get(0);
                    Pizza pizza = new Pizza();
                    pizza.setId(dto.id);
                    pizza.setName(dto.name);
                    pizza.setPrice(dto.price);
                    Base base = new Base(dto.id);
                    base.setName(dto.baseName);
                    pizza.setBase(base);
                    pizza.setToppings(e.getValue().stream()
                            .map(x -> {
                                Topping topping = new Topping(x.toppingId);
                                topping.setName(x.toppingName);
                                return topping;
                            })
                            .collect(Collectors.toList()));
                    return pizza;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public Pizza save(Pizza pizza) {
        com.example.doma.Pizza dto = new com.example.doma.Pizza();
        dto.id = pizza.getId();
        dto.name = pizza.getName();
        dto.price = pizza.getPrice();
        dto.baseId = pizza.getBase().getId();
        pizzaDao.insert(dto);
        pizzaDao.insertToppings(pizza.getToppings().stream()
                .map(x -> {
                    PizzaToppings pt = new PizzaToppings();
                    pt.pizzaId = dto.id;
                    pt.toppingsId = x.getId();
                    return pt;
                }).collect(Collectors.toList()));
        return pizza;
    }
}
