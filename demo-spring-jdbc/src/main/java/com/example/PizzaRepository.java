package com.example;

import com.example.model.Base;
import com.example.model.Pizza;
import com.example.model.Topping;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PizzaRepository {
    private final JdbcTemplate jdbcTemplate;

    public PizzaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pizza> findOrderByIdAsc() {
        return jdbcTemplate.query("SELECT p.id, p.name, p.price, b.id AS baseId, b.name AS baseName, t.id AS toppingId, t.name AS toppingName FROM pizza p INNER JOIN base b ON (b.id = p.base_id) INNER JOIN pizza_toppings pt ON (pt.pizza_id = p.id) INNER JOIN topping t ON (t.id = pt.toppings_id) ORDER BY p.id ASC", rs -> {
            List<Pizza> pizzas = new ArrayList<>();
            Pizza pizza = null;
            while (rs.next()) {
                Long pizzaId = rs.getLong("id");
                if (pizza == null || !pizzaId.equals(pizza.getId())) {
                    pizza = new Pizza();
                    pizza.setId(pizzaId);
                    pizza.setName(rs.getNString("name"));
                    pizza.setPrice(rs.getBigDecimal("price"));
                    Base base = new Base(rs.getLong("baseId"));
                    pizza.setBase(base);
                    base.setName(rs.getString("baseName"));
                    pizza.setToppings(new ArrayList<>());
                    pizzas.add(pizza);
                }
                Topping topping = new Topping(rs.getLong("toppingId"));
                topping.setName(rs.getString("toppingName"));
                pizza.getToppings().add(topping);
            }
            return pizzas;
        });
    }

    @Transactional
    public Pizza save(Pizza pizza) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO pizza (base_id, name, price) VALUES (?, ?, ?)");
            ps.setLong(1, pizza.getBase().getId());
            ps.setString(2, pizza.getName());
            ps.setBigDecimal(3, pizza.getPrice());
            return ps;
        }, keyHolder);
        long pizzaId = keyHolder.getKey().longValue();
        jdbcTemplate.batchUpdate("INSERT INTO pizza_toppings (pizza_id, toppings_id) VALUES (?, ?)",
                pizza.getToppings().stream().map(t -> new Object[]{pizzaId, t.getId()}).collect(Collectors.toList()));
        pizza.setId(pizzaId);
        return pizza;
    }
}
