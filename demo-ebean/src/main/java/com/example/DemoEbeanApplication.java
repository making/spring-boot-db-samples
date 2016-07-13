package com.example;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.model.Base;
import com.example.model.Pizza;
import com.example.model.Topping;

@SpringBootApplication
public class DemoEbeanApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEbeanApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(PizzaRepository pizzaRepository) {
        return a -> {
            Pizza pizza = new Pizza();
            pizza.setBase(new Base(1L));
            pizza.setToppings(Arrays.asList(new Topping(1L), new Topping(2L), new Topping(3L), new Topping(4L), new Topping(5L)));
            pizza.setName("Hello Pizza");
            pizza.setPrice(new BigDecimal("1000"));
            pizzaRepository.save(pizza);
        };
    }
}
