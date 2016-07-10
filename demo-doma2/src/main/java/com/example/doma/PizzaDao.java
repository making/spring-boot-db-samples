package com.example.doma;

import com.example.doma.Pizza;
import com.example.doma.PizzaToppings;
import org.seasar.doma.BatchInsert;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@ConfigAutowireable
@Dao
public interface PizzaDao {
    @Select
    List<Pizza> findOrderByIdAsc();

    @Insert
    int insert(Pizza pizza);

    @BatchInsert
    int[] insertToppings(List<PizzaToppings> pizzaToppingses);
}