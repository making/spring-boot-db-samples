package com.example;

import com.example.model.Base;
import com.example.model.Pizza;
import com.example.model.Topping;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.sql2o.Sql2o;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class DemoSql2oApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSql2oApplication.class, args);
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
	Sql2o sql2o(DataSource dataSource) {
		return new Sql2o(dataSource);
	}
}
