package com.example.model;

import java.io.Serializable;

public class Base implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;

    public Base(Long id) {
        this.id = id;
    }

    Base() {

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

    @Override
    public String toString() {
        return "Base{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Base)) return false;

        Base base = (Base) o;

        if (id != null ? !id.equals(base.id) : base.id != null) return false;
        return name != null ? name.equals(base.name) : base.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
