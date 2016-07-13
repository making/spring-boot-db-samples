package com.example.querydsl;

import javax.annotation.Generated;
import java.io.Serializable;

/**
 * Base is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class Base implements Serializable {

    private Long id;

    private String name;

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

    @Override
    public String toString() {
         return "id = " + id + ", name = " + name;
    }

}

