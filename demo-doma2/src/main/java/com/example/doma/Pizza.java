package com.example.doma;

import org.seasar.doma.*;

import java.math.BigDecimal;

@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public BigDecimal price;
    public Long baseId;
    @Column(insertable = false)
    public String baseName;
    @Column(insertable = false)
    public Long toppingId;
    @Column(insertable = false)
    public String toppingName;

    @Override
    public String toString() {
        return "Pizza{" +
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
