package com.example;

import com.example.model.Pizza;
import com.example.querydsl.QBase;
import com.example.querydsl.QPizza;
import com.example.querydsl.QPizzaToppings;
import com.example.querydsl.QTopping;
import com.querydsl.core.Tuple;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.dml.SQLInsertClause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
//        List<Result<Record>> values = dslContext.selectDistinct()
//                .from(PIZZA)
//                .innerJoin(BASE).on(BASE.ID.eq(PIZZA.BASE_ID))
//                .innerJoin(PIZZA_TOPPINGS).on(PIZZA_TOPPINGS.PIZZA_ID.eq(PIZZA.ID))
//                .innerJoin(TOPPING).on(TOPPING.ID.eq(PIZZA_TOPPINGS.TOPPINGS_ID))
//                .orderBy(PIZZA.ID.asc())
//                .fetch()
//                .intoGroups(PIZZA.fields())
//                .values()
//                .stream()
//                .collect(Collectors.toList());
//        if (values.isEmpty()) {
//            return Collections.emptyList();
//        }
//        return values.stream()
//                .map(r -> {
//                    Pizza pizza = r.into(PIZZA.ID, PIZZA.NAME, PIZZA.PRICE).get(0).into(Pizza.class);
//                    pizza.setBase(r.into(BASE.ID, BASE.NAME).get(0).into(Base.class));
//                    pizza.setToppings(r.sortAsc(TOPPING.ID).into(Topping.class));
//                    return pizza;
//                })
//                .collect(Collectors.toList());
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
        return values.stream()
                .map(tuple -> {
                    Pizza pizza = new Pizza();
                    pizza.setId(tuple.get(qPizza.id));
                    pizza.setName(tuple.get(qPizza.name));
                    pizza.setPrice(tuple.get(qPizza.price));
                    return pizza;
                })
                .collect(Collectors.toList());
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
