package com.example.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QPizza is a Querydsl query type for Pizza
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QPizza extends com.querydsl.sql.RelationalPathBase<Pizza> {

    private static final long serialVersionUID = -522104512;

    public static final QPizza pizza = new QPizza("PIZZA");

    public final NumberPath<Long> baseId = createNumber("baseId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<java.math.BigDecimal> price = createNumber("price", java.math.BigDecimal.class);

    public final com.querydsl.sql.PrimaryKey<Pizza> constraint4 = createPrimaryKey(id);

    public final com.querydsl.sql.ForeignKey<Base> fkm6kai6c5evr38duyfh06ue29u = createForeignKey(baseId, "ID");

    public final com.querydsl.sql.ForeignKey<PizzaToppings> _fk78l5qtferc9qhfkkgyv99lmst = createInvForeignKey(id, "PIZZA_ID");

    public QPizza(String variable) {
        super(Pizza.class, forVariable(variable), "PUBLIC", "PIZZA");
        addMetadata();
    }

    public QPizza(String variable, String schema, String table) {
        super(Pizza.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QPizza(Path<? extends Pizza> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "PIZZA");
        addMetadata();
    }

    public QPizza(PathMetadata metadata) {
        super(Pizza.class, metadata, "PUBLIC", "PIZZA");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(baseId, ColumnMetadata.named("BASE_ID").withIndex(4).ofType(Types.BIGINT).withSize(19));
        addMetadata(id, ColumnMetadata.named("ID").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(name, ColumnMetadata.named("NAME").withIndex(2).ofType(Types.VARCHAR).withSize(255));
        addMetadata(price, ColumnMetadata.named("PRICE").withIndex(3).ofType(Types.DECIMAL).withSize(19).withDigits(2));
    }

}

