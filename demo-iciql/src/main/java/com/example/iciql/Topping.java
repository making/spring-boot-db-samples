package com.example.iciql;

import com.iciql.Iciql.IQColumn;
import com.iciql.Iciql.IQTable;

@IQTable(name = "topping")
public class Topping {
    @IQColumn(primaryKey = true, autoIncrement = true)
    public Long id;
    @IQColumn
    public String name;
}
