package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Pizza implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    @ManyToMany
    private List<Topping> toppings;
    @ManyToOne
    private Base base;

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

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", toppings=" + toppings +
                ", base=" + base +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pizza)) return false;

        Pizza pizza = (Pizza) o;

        if (id != null ? !id.equals(pizza.id) : pizza.id != null) return false;
        if (name != null ? !name.equals(pizza.name) : pizza.name != null) return false;
        if (price != null ? !price.equals(pizza.price) : pizza.price != null) return false;
        if (toppings != null ? !toppings.equals(pizza.toppings) : pizza.toppings != null) return false;
        return base != null ? base.equals(pizza.base) : pizza.base == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (toppings != null ? toppings.hashCode() : 0);
        result = 31 * result + (base != null ? base.hashCode() : 0);
        return result;
    }
}
