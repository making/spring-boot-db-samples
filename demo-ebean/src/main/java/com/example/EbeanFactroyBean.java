package com.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.springsupport.txn.SpringAwareJdbcTransactionManager;

@Component
public class EbeanFactroyBean implements FactoryBean<EbeanServer> {

    @Autowired
    DataSource dataSource;

    @Override
    public EbeanServer getObject() throws Exception {

        ServerConfig config = new ServerConfig();
        config.setName("default");
        config.setDataSource(dataSource);
        config.setExternalTransactionManager(new SpringAwareJdbcTransactionManager());
        config.setDefaultServer(true);
        config.setRegister(true);

        return EbeanServerFactory.create(config);
    }

    @Override
    public Class<?> getObjectType() {
        return EbeanServer.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
