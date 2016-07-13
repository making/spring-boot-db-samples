package com.example;

import com.example.model.Base;
import com.example.model.Pizza;
import com.example.model.Topping;
import com.querydsl.sql.H2Templates;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.SQLTemplates;
import com.querydsl.sql.spring.SpringConnectionProvider;
import com.querydsl.sql.spring.SpringExceptionTranslator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.inject.Provider;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Arrays;

@SpringBootApplication
public class DemoQueryDslApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoQueryDslApplication.class, args);
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

    @Bean
    public com.querydsl.sql.Configuration querydslConfiguration() {
        SQLTemplates templates = H2Templates.builder().build();
        com.querydsl.sql.Configuration configuration = new com.querydsl.sql.Configuration(templates);
        configuration.setExceptionTranslator(new SpringExceptionTranslator());
        return configuration;
    }

    @Bean
    public SQLQueryFactory sqlQueryFactory(DataSource dataSource) {
        Provider<Connection> provider = new SpringConnectionProvider(dataSource);
        return new SQLQueryFactory(querydslConfiguration(), provider);
    }
}
