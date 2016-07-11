package com.example;

import com.example.model.Base;
import com.example.model.Pizza;
import com.example.model.Topping;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PizzaRepository {
    private final Sql2o sql2o;

    public PizzaRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<Pizza> findOrderByIdAsc() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT p.id, p.name, p.price, b.id AS baseId, b.name AS baseName, t.id AS toppingId, t.name AS toppingName FROM pizza p INNER JOIN base b ON (b.id = p.base_id) INNER JOIN pizza_toppings pt ON (pt.pizza_id = p.id) INNER JOIN topping t ON (t.id = pt.toppings_id) ORDER BY p.id ASC")
                    .executeAndFetch(PizzaDto.class)
                    .stream()
                    .collect(Collectors.groupingBy(PizzaDto::getId))
                    .entrySet()
                    .stream()
                    .map(e -> {
                        PizzaDto dto = e.getValue().get(0);
                        Pizza pizza = new Pizza();
                        pizza.setId(dto.getId());
                        pizza.setName(dto.getName());
                        pizza.setPrice(dto.getPrice());
                        Base base = new Base(dto.getId());
                        base.setName(dto.getBaseName());
                        pizza.setBase(base);
                        pizza.setToppings(e.getValue().stream()
                                .map(x -> {
                                    Topping topping = new Topping(x.getToppingId());
                                    topping.setName(x.getToppingName());
                                    return topping;
                                })
                                .collect(Collectors.toList()));
                        return pizza;
                    })
                    .collect(Collectors.toList());
        }
    }

    // @Transactional TODO transaction management by @Transactional
    public Pizza save(Pizza pizza) {
        try (Connection con = sql2o.beginTransaction()) {
            long pizzaId = (long) con.createQuery("INSERT INTO pizza (base_id, name, price) VALUES (:baseId, :name, :price)", true)
                    .addParameter("baseId", pizza.getBase().getId())
                    .addParameter("name", pizza.getName())
                    .addParameter("price", pizza.getPrice())
                    .executeUpdate()
                    .getKey();
            Query queryForPt = con.createQuery("INSERT INTO pizza_toppings (pizza_id, toppings_id) VALUES (:pizzaId, :toppingsId)");
            pizza.getToppings().forEach(t ->
                    queryForPt
                            .addParameter("pizzaId", pizzaId)
                            .addParameter("toppingsId", t.getId())
                            .addToBatch());
            queryForPt.executeBatch();
            con.commit();
        }
        return pizza;
    }

    private static class PizzaDto {
        private Long id;
        private String name;
        private BigDecimal price;
        private Long baseId;
        private String baseName;
        private Long toppingId;
        private String toppingName;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public Long getBaseId() {
            return baseId;
        }

        public void setBaseId(Long baseId) {
            this.baseId = baseId;
        }

        public String getBaseName() {
            return baseName;
        }

        public void setBaseName(String baseName) {
            this.baseName = baseName;
        }

        public Long getToppingId() {
            return toppingId;
        }

        public void setToppingId(Long toppingId) {
            this.toppingId = toppingId;
        }

        public String getToppingName() {
            return toppingName;
        }

        public void setToppingName(String toppingName) {
            this.toppingName = toppingName;
        }

        @Override
        public String toString() {
            return "PizzaDto{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", baseId=" + baseId +
                    ", baseName='" + baseName + '\'' +
                    ", toppingId=" + toppingId +
                    ", toppingName='" + toppingName + '\'' +
                    '}';
        }
    }
}


