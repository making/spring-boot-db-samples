package com.example;

import com.example.model.Base;
import com.example.model.Pizza;
import com.example.model.Topping;
import com.example.mybatis.PizzaMapper;
import com.example.mybatis.PizzaToppings;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PizzaRepository {
    private final PizzaMapper pizzaMapper;

    public PizzaRepository(PizzaMapper pizzaMapper) {
        this.pizzaMapper = pizzaMapper;
    }

    public List<Pizza> findOrderByIdAsc() {
        return pizzaMapper.findOrderByIdAsc().stream()
                .collect(Collectors.groupingBy(com.example.mybatis.Pizza::getId))
                .entrySet()
                .stream()
                .map(e -> {
                    com.example.mybatis.Pizza dto = e.getValue().get(0);
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
        com.example.mybatis.Pizza dto = new com.example.mybatis.Pizza();
        dto.setName(pizza.getName());
        dto.setPrice(pizza.getPrice());
        dto.setBaseId(pizza.getBase().getId());
        pizzaMapper.insert(dto);
        // TODO batch insert
        pizza.getToppings().forEach(t -> pizzaMapper.insertToppings(new PizzaToppings(dto.getId(), t.getId())));
        return pizza;
    }
}
