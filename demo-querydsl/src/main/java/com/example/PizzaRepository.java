package com.example;

import com.example.model.Base;
import com.example.model.Pizza;
import com.example.model.Topping;
import com.example.querydsl.QBase;
import com.example.querydsl.QPizza;
import com.example.querydsl.QPizzaToppings;
import com.example.querydsl.QTopping;
import com.querydsl.core.Tuple;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.dml.SQLInsertClause;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class PizzaRepository {

    @Autowired
    private SQLQueryFactory sqlQueryFactory;

    private final QPizza qPizza = QPizza.pizza;
    private final QPizzaToppings qPizzaToppings = QPizzaToppings.pizzaToppings;
    private final QBase qBase = QBase.base;
    private final QTopping qTopping = QTopping.topping;

    public List<Pizza> findOrderByIdAsc() {
        List<Tuple> values = sqlQueryFactory
                .select(qPizza.id, qPizza.name, qPizza.price, qBase.id, qBase.name, qTopping.id, qTopping.name)
                .from(qPizza)
                .innerJoin(qBase).on(qBase.id.eq(qPizza.baseId))
                .innerJoin(qPizzaToppings).on(qPizzaToppings.pizzaId.eq(qPizza.id))
                .innerJoin(qTopping).on(qTopping.id.eq(qPizzaToppings.toppingsId))
                .orderBy(qPizza.id.asc())
                .fetch()
                .stream()
                .collect(Collectors.toList());
        if (values.isEmpty()) {
            return Collections.emptyList();
        }
        List<Pizza> pizzas = new ArrayList<>();
        Pizza pizza = null;
        for (Tuple tuple : values) {
            Long pizzaId = tuple.get(qPizza.id);
            if (pizza == null || !pizza.getId().equals(pizzaId)) {
                pizza = new Pizza();
                pizza.setId(pizzaId);
                pizza.setName(tuple.get(qPizza.name));
                pizza.setPrice(tuple.get(qPizza.price));
                Base base = new Base(tuple.get(qBase.id));
                base.setId(tuple.get(qBase.id));
                base.setName(tuple.get(qBase.name));
                pizza.setBase(base);
                pizza.setToppings(new ArrayList<>());
                pizzas.add(pizza);
            }
            Topping topping = new Topping(tuple.get(qTopping.id));
            topping.setName(tuple.get(qTopping.name));
            pizza.getToppings().add(topping);
        }
        return pizzas;
    }

    public Pizza save(Pizza pizza) {

        Long pizzaId = sqlQueryFactory.insert(qPizza)
                .columns(qPizza.baseId, qPizza.name, qPizza.price)
                .values(pizza.getBase().getId(), pizza.getName(), pizza.getPrice())
                .executeWithKey(Long.class);

        SQLInsertClause insert = sqlQueryFactory.insert(qPizzaToppings);
        pizza.getToppings().forEach(tpg -> insert.values(pizzaId, tpg.getId()).addBatch());
        insert.execute();

        pizza.setId(pizzaId);
        return pizza;
    }
}