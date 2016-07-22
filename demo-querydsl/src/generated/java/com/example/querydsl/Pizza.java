package com.example.querydsl;

import javax.annotation.Generated;
import java.io.Serializable;

/**
 * Pizza is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class Pizza implements Serializable {

    private Long baseId;

    private Long id;

    private String name;

    private java.math.BigDecimal price;

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

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

    public java.math.BigDecimal getPrice() {
        return price;
    }

    public void setPrice(java.math.BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
         return "baseId = " + baseId + ", id = " + id + ", name = " + name + ", price = " + price;
    }

}

