package com.example.iciql;

import com.iciql.Iciql.IQColumn;
import com.iciql.Iciql.IQTable;

@IQTable(name = "base")
public class Base {
    @IQColumn(primaryKey = true, autoIncrement = true)
    public Long id;
    @IQColumn
    public String name;
}
