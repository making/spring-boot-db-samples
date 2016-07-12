package com.example.dbflute.allcommon;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.dbflute.bhv.core.BehaviorCommandInvoker;
import org.dbflute.bhv.core.InvokerAssistant;
import com.example.dbflute.allcommon.DBFluteInitializer;

/**
 * The Java configuration of DBFlute beans for Spring Framework. <br>
 * You can inject them by importing this class in your auto configuration class.
 * @author DBFlute(AutoGenerator)
 */
@Configuration
@ComponentScan(value="com.example.dbflute.exbhv", lazyInit=true)
public class DBFluteBeansJavaConfig {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Autowired
    protected ApplicationContext _container;

    @Resource(name="dataSource")
    protected DataSource _dataSource; // name basis here for multiple DB

    // ===================================================================================
    //                                                                   Runtime Component
    //                                                                   =================
    @Bean(name="introduction")
    public DBFluteInitializer createDBFluteInitializer() { // no lazy for initialize-only component
        return new com.example.dbflute.allcommon.DBFluteInitializer(_dataSource);
    }

    @Bean(name="invokerAssistant")
    @Lazy
    public InvokerAssistant createImplementedInvokerAssistant() {
        ImplementedInvokerAssistant assistant = newImplementedInvokerAssistant();
        assistant.setDataSource(_dataSource);
        return assistant;
    }

    protected ImplementedInvokerAssistant newImplementedInvokerAssistant() {
        return new com.example.dbflute.allcommon.ImplementedInvokerAssistant();
    }

    @Bean(name="behaviorCommandInvoker")
    @Lazy
    public BehaviorCommandInvoker createBehaviorCommandInvoker() {
        BehaviorCommandInvoker invoker = newBehaviorCommandInvoker();
        invoker.setInvokerAssistant(createImplementedInvokerAssistant());
        return invoker;
    }

    protected BehaviorCommandInvoker newBehaviorCommandInvoker() {
        return new BehaviorCommandInvoker();
    }

    @Bean(name="behaviorSelector")
    @Lazy
    public ImplementedBehaviorSelector createImplementedBehaviorSelector() {
        ImplementedBehaviorSelector selector = newImplementedBehaviorSelector();
        selector.setContainer(_container);
        return selector;
    }

    protected ImplementedBehaviorSelector newImplementedBehaviorSelector() {
        return new ImplementedBehaviorSelector();
    }

    @Bean(name="commonColumnAutoSetupper")
    @Lazy
    public ImplementedCommonColumnAutoSetupper createImplementedCommonColumnAutoSetupper() {
        return newImplementedCommonColumnAutoSetupper();
    }

    protected ImplementedCommonColumnAutoSetupper newImplementedCommonColumnAutoSetupper() {
        return new ImplementedCommonColumnAutoSetupper();
    }
}
