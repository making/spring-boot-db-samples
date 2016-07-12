package com.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.iciql.PizzaToppings;
import com.example.model.Base;
import com.example.model.Pizza;
import com.example.model.Topping;
import com.iciql.Db;

@Repository
public class PizzaRepository {
    private final DataSource dataSource;

    public PizzaRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Pizza> findOrderByIdAsc() {
        try (Db db = Db.open(dataSource)) {

            com.example.iciql.Pizza p = new com.example.iciql.Pizza();
            com.example.iciql.Base b = new com.example.iciql.Base();
            PizzaToppings pt = new PizzaToppings();
            com.example.iciql.Topping t = new com.example.iciql.Topping();
    
            List<PizzaView> list = db.from(p)
                .innerJoin(b).on(b.id).is(p.baseId)
                .innerJoin(pt).on(pt.pizzaId).is(p.id)
                .innerJoin(t).on(t.id).is(pt.toppingsId)
                .orderBy(p.id)
                .select(new PizzaView() {{
                    id = p.id;
                    name = p.name;
                    price = p.price;
                    baseId = b.id;
                    baseName = b.name;
                    toppingId = t.id;
                    toppingName = t.name;
                }});
            
            
            return list.stream().collect(toPizzaList());
        }
    }

    @Transactional
    public Pizza save(Pizza pizza) {
        try(Db db = Db.open(dataSource)) {

            com.example.iciql.Pizza p = new com.example.iciql.Pizza();
            p.baseId = pizza.getBase().getId();
            p.name = pizza.getName();
            p.price = pizza.getPrice();
            long pizzaId = db.insertAndGetKey(p);

            List<PizzaToppings> pizzaToppings = pizza.getToppings().stream().map(t -> {
                PizzaToppings pt = new PizzaToppings();
                pt.pizzaId = pizzaId;
                pt.toppingsId = t.getId();
                return pt;
            }).collect(Collectors.toList());
            db.insertAll(pizzaToppings);

            pizza.setId(pizzaId);
            return pizza;
        }
    }

    private static Collector<PizzaView, ?, List<Pizza>> toPizzaList() {
        BiConsumer<LinkedHashMap<Long, Pizza>, PizzaView> accumulator = (acc, pv) -> {

            Topping t = new Topping(pv.toppingId);
            t.setName(pv.toppingName);

            Pizza p = acc.computeIfAbsent(pv.id, pv::toPizza);
            p.getToppings().add(t);

            acc.put(pv.id, p);
        };
        return Collector.of(LinkedHashMap::new, accumulator, (l, r) -> {
            r.forEach((key, value) -> l.merge(key, value, (p1, p2) -> {
                p1.getToppings().addAll(p2.getToppings());
                return p1;
            }));
            return l;
        }, map -> new ArrayList<>(map.values()));
    }

    public static class PizzaView {
        public Long id;
        public String name;
        public BigDecimal price;
        public Long baseId;
        public String baseName;
        public Long toppingId;
        public String toppingName;
        public Pizza toPizza(Long id) {
            Pizza pizza = new Pizza();
            pizza.setId(id);
            pizza.setName(name);
            pizza.setPrice(price);
            Base base = new Base(id);
            base.setName(baseName);
            pizza.setBase(base);
            pizza.setToppings(new ArrayList<>());
            return pizza;
        }
    }
}
