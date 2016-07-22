package com.example.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QPizzaToppings is a Querydsl query type for PizzaToppings
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QPizzaToppings extends com.querydsl.sql.RelationalPathBase<PizzaToppings> {

    private static final long serialVersionUID = -213062036;

    public static final QPizzaToppings pizzaToppings = new QPizzaToppings("PIZZA_TOPPINGS");

    public final NumberPath<Long> pizzaId = createNumber("pizzaId", Long.class);

    public final NumberPath<Long> toppingsId = createNumber("toppingsId", Long.class);

    public final com.querydsl.sql.PrimaryKey<PizzaToppings> constraintA = createPrimaryKey(pizzaId, toppingsId);

    public final com.querydsl.sql.ForeignKey<Topping> fk7tcti2cxau3csvbuwxn0scb93 = createForeignKey(toppingsId, "ID");

    public final com.querydsl.sql.ForeignKey<Pizza> fk78l5qtferc9qhfkkgyv99lmst = createForeignKey(pizzaId, "ID");

    public QPizzaToppings(String variable) {
        super(PizzaToppings.class, forVariable(variable), "PUBLIC", "PIZZA_TOPPINGS");
        addMetadata();
    }

    public QPizzaToppings(String variable, String schema, String table) {
        super(PizzaToppings.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QPizzaToppings(Path<? extends PizzaToppings> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "PIZZA_TOPPINGS");
        addMetadata();
    }

    public QPizzaToppings(PathMetadata metadata) {
        super(PizzaToppings.class, metadata, "PUBLIC", "PIZZA_TOPPINGS");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(pizzaId, ColumnMetadata.named("PIZZA_ID").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(toppingsId, ColumnMetadata.named("TOPPINGS_ID").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
    }

}

