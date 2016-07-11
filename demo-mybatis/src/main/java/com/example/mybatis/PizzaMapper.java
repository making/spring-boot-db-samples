package com.example.mybatis;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PizzaMapper {
    @Insert("INSERT INTO pizza (base_id, name, price) VALUES (#{baseId}, #{name}, #{price})")
    @Options(useGeneratedKeys = true)
    void insert(Pizza pizza);

    @Insert("INSERT INTO pizza_toppings (pizza_id, toppings_id) VALUES (#{pizzaId}, #{toppingsId})")
    int insertToppings(PizzaToppings pizzaToppings);

    @Select("SELECT p.id, p.name, p.price, b.id AS baseId, b.name AS baseName, t.id AS toppingId, t.name AS toppingName FROM pizza p INNER JOIN base b ON (b.id = p.base_id) INNER JOIN pizza_toppings pt ON (pt.pizza_id = p.id) INNER JOIN topping t ON (t.id = pt.toppings_id) ORDER BY p.id ASC")
    List<Pizza> findOrderByIdAsc();

    @Flush
    void flush();
}
