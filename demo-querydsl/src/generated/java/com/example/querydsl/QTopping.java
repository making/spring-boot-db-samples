package com.example.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QTopping is a Querydsl query type for Topping
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QTopping extends com.querydsl.sql.RelationalPathBase<Topping> {

    private static final long serialVersionUID = 186038015;

    public static final QTopping topping = new QTopping("TOPPING");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final com.querydsl.sql.PrimaryKey<Topping> constraintE = createPrimaryKey(id);

    public final com.querydsl.sql.ForeignKey<PizzaToppings> _fk7tcti2cxau3csvbuwxn0scb93 = createInvForeignKey(id, "TOPPINGS_ID");

    public QTopping(String variable) {
        super(Topping.class, forVariable(variable), "PUBLIC", "TOPPING");
        addMetadata();
    }

    public QTopping(String variable, String schema, String table) {
        super(Topping.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QTopping(Path<? extends Topping> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "TOPPING");
        addMetadata();
    }

    public QTopping(PathMetadata metadata) {
        super(Topping.class, metadata, "PUBLIC", "TOPPING");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("ID").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(name, ColumnMetadata.named("NAME").withIndex(2).ofType(Types.VARCHAR).withSize(255));
    }

}

