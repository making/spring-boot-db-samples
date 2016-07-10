package com.example;

import com.example.model.Base;
import com.example.model.Pizza;
import com.example.model.Topping;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class DemoSpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringDataJpaApplication.class, args);
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
