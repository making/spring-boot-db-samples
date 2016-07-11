package com.example.jdbi;

import org.skife.jdbi.v2.BeanMapper;


public class PizzaMapper extends BeanMapper<Pizza> {
    public PizzaMapper() {
        super(Pizza.class);
    }
}
