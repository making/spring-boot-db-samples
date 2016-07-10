package com.example;

import com.example.model.Base;
import com.example.model.Pizza;
import com.example.model.Topping;
import org.jooq.DSLContext;
import org.jooq.Query;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

import static com.example.jooq.tables.Topping.TOPPING;
import static com.example.jooq.tables.Base.BASE;
import static com.example.jooq.tables.Pizza.PIZZA;
import static com.example.jooq.tables.PizzaToppings.PIZZA_TOPPINGS;

@Repository
public class PizzaRepository {
    private final DSLContext dslContext;

    public PizzaRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<Pizza> findOrderByIdAsc() {
        List<Result<Record>> values = dslContext.selectDistinct()
                .from(PIZZA)
                .innerJoin(BASE).on(BASE.ID.eq(PIZZA.BASE_ID))
                .innerJoin(PIZZA_TOPPINGS).on(PIZZA_TOPPINGS.PIZZA_ID.eq(PIZZA.ID))
                .innerJoin(TOPPING).on(TOPPING.ID.eq(PIZZA_TOPPINGS.TOPPINGS_ID))
                .orderBy(PIZZA.ID.asc())
                .fetch()
                .intoGroups(PIZZA.fields())
                .values()
                .stream()
                .collect(Collectors.toList());
        if (values.isEmpty()) {
            return Collections.emptyList();
        }
        return values.stream()
                .map(r -> {
                    Pizza pizza = r.into(PIZZA.ID, PIZZA.NAME, PIZZA.PRICE).get(0).into(Pizza.class);
                    pizza.setBase(r.into(BASE.ID, BASE.NAME).get(0).into(Base.class));
                    pizza.setToppings(r.sortAsc(TOPPING.ID).into(Topping.class));
                    return pizza;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public Pizza save(Pizza pizza) {
        Long pizzaId = dslContext.insertInto(PIZZA, PIZZA.BASE_ID, PIZZA.NAME, PIZZA.PRICE)
                .values(pizza.getBase().getId(), pizza.getName(), pizza.getPrice())
                .returning(PIZZA.ID)
                .fetchOne()
                .getId();
        int[] x = dslContext.batch(pizza.getToppings().stream()
                .map(t -> dslContext
                        .insertInto(PIZZA_TOPPINGS, PIZZA_TOPPINGS.PIZZA_ID, PIZZA_TOPPINGS.TOPPINGS_ID)
                        .values(pizzaId, t.getId()))
                .toArray(Query[]::new))
                .execute();
        pizza.setId(pizzaId);
        return pizza;
    }
}
