package com.example.jdbi;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.math.BigDecimal;
import java.util.List;

public interface PizzaDao {
    @SqlUpdate("INSERT INTO pizza(base_id, name, price) VALUES (:baseId, :name, :price)")
    @GetGeneratedKeys
    long insertPizza(@Bind("baseId") Long baseId, @Bind("name") String name, @Bind("price") BigDecimal price);

    @SqlBatch("INSERT INTO pizza_toppings (pizza_id, toppings_id) VALUES (:pizzaId, :toppingsId)")
    void insertPizzaToppings(@Bind("pizzaId") Long pizzaId, @Bind("toppingsId") List<Long> toppingsIds);

    @SqlQuery("SELECT p.id, p.name, p.price, b.id AS baseId, b.name AS baseName, t.id AS toppingId, t.name AS toppingName FROM pizza p INNER JOIN base b ON (b.id = p.base_id) INNER JOIN pizza_toppings pt ON (pt.pizza_id = p.id) INNER JOIN topping t ON (t.id = pt.toppings_id) ORDER BY p.id ASC")
    @Mapper(PizzaMapper.class)
    List<Pizza> findOrderByIdAsc();

    void close();
}
