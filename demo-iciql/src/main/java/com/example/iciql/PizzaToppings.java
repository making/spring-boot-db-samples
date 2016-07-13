package com.example.iciql;

import com.iciql.Iciql.IQColumn;
import com.iciql.Iciql.IQTable;

@IQTable(name = "pizza_toppings")
public class PizzaToppings {
    @IQColumn(name = "pizza_id", primaryKey = true)
    public Long pizzaId;
    @IQColumn(name = "toppings_id", primaryKey = true)
    public Long toppingsId;
}
