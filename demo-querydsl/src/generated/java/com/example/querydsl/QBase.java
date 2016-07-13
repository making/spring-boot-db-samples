package com.example.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QBase is a Querydsl query type for Base
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QBase extends com.querydsl.sql.RelationalPathBase<Base> {

    private static final long serialVersionUID = 1229658905;

    public static final QBase base = new QBase("BASE");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final com.querydsl.sql.PrimaryKey<Base> constraint1 = createPrimaryKey(id);

    public final com.querydsl.sql.ForeignKey<Pizza> _fkm6kai6c5evr38duyfh06ue29u = createInvForeignKey(id, "BASE_ID");

    public QBase(String variable) {
        super(Base.class, forVariable(variable), "PUBLIC", "BASE");
        addMetadata();
    }

    public QBase(String variable, String schema, String table) {
        super(Base.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QBase(Path<? extends Base> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "BASE");
        addMetadata();
    }

    public QBase(PathMetadata metadata) {
        super(Base.class, metadata, "PUBLIC", "BASE");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("ID").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(name, ColumnMetadata.named("NAME").withIndex(2).ofType(Types.VARCHAR).withSize(255));
    }

}

