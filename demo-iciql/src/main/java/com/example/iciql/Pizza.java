package com.example.iciql;

import java.math.BigDecimal;

import com.iciql.Iciql.IQColumn;
import com.iciql.Iciql.IQTable;

@IQTable(name = "pizza")
public class Pizza {
    @IQColumn(primaryKey = true, autoIncrement = true)
    public Long id;
    @IQColumn
    public String name;
    @IQColumn
    public BigDecimal price;
    @IQColumn(name = "base_id")
    public Long baseId;
}
