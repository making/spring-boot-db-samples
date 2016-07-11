package com.example;

import bitronix.tm.BitronixTransactionSynchronizationRegistry;
import com.example.model.Base;
import com.example.model.Pizza;
import com.example.model.Topping;
import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.jdbc.dialect.H2Dialect;
import org.seasar.extension.jdbc.manager.JdbcManagerImpl;
import org.seasar.extension.jdbc.meta.ColumnMetaFactoryImpl;
import org.seasar.extension.jdbc.meta.EntityMetaFactoryImpl;
import org.seasar.extension.jdbc.meta.PropertyMetaFactoryImpl;
import org.seasar.extension.jdbc.meta.TableMetaFactoryImpl;
import org.seasar.framework.convention.impl.PersistenceConventionImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;
import javax.transaction.TransactionSynchronizationRegistry;
import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class DemoS2jdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoS2jdbcApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(PizzaRepository pizzaRepository) {
        return a -> {
            Pizza pizza = new Pizza();
            pizza.setBase(new Base(1L));
            pizza.setToppings(Arrays.asList(new Topping(1L), new Topping(2L), new Topping(3L), new Topping(4L), new Topping(5L)));
            pizza.setName("Hello Pizza");
            pizza.setPrice(new BigDecimal("1000"));
            pizzaRepository.save(pizza);
        };
    }

    @Bean
    TransactionSynchronizationRegistry synchronizationRegistry(TransactionManager transactionManager) {
        return new BitronixTransactionSynchronizationRegistry();
    }

    @Bean
    JdbcManager jdbcManager(DataSource dataSource, TransactionSynchronizationRegistry syncRegistry) {
        PersistenceConventionImpl persistenceConvention = new PersistenceConventionImpl();
        ColumnMetaFactoryImpl columnMetaFactory = new ColumnMetaFactoryImpl();
        columnMetaFactory.setPersistenceConvention(persistenceConvention);
        PropertyMetaFactoryImpl propertyMetaFactory = new PropertyMetaFactoryImpl();
        propertyMetaFactory.setColumnMetaFactory(columnMetaFactory);
        propertyMetaFactory.setPersistenceConvention(persistenceConvention);
        TableMetaFactoryImpl tableMetaFactory = new TableMetaFactoryImpl();
        tableMetaFactory.setPersistenceConvention(persistenceConvention);
        EntityMetaFactoryImpl entityMetaFactory = new EntityMetaFactoryImpl();
        entityMetaFactory.setPersistenceConvention(persistenceConvention);
        entityMetaFactory.setPropertyMetaFactory(propertyMetaFactory);
        entityMetaFactory.setTableMetaFactory(tableMetaFactory);
        H2Dialect dialect = new H2Dialect();
        JdbcManagerImpl jdbcManager = new JdbcManagerImpl();
        jdbcManager.setDataSource(dataSource);
        jdbcManager.setDialect(dialect);
        jdbcManager.setEntityMetaFactory(entityMetaFactory);
        jdbcManager.setPersistenceConvention(persistenceConvention);
        jdbcManager.setSyncRegistry(syncRegistry);
        return jdbcManager;
    }
}
