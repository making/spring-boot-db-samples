package com.example;

import com.example.model.Base;
import com.example.model.Pizza;
import com.example.model.Topping;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PizzaControllerTests {

    @Autowired
    TestRestTemplate restTemplate;
    @Autowired
    ObjectMapper objectMapper;

    private JacksonTester<List<Pizza>> json;

    @Before
    public void setup() {
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    public void contextLoads() throws Exception {
        Pizza pizza = new Pizza();
        pizza.setBase(new Base(2L));
        pizza.setToppings(Arrays.asList(new Topping(3L), new Topping(10L)));
        pizza.setName("Spring Pizza");
        pizza.setPrice(new BigDecimal("1200"));
        restTemplate.postForObject("/", pizza, Void.class);
        List<Pizza> ret = Arrays.asList(restTemplate.getForObject("/", Pizza[].class));
        assertThat(json.write(ret)).isEqualToJson("expected.json");
    }

}
