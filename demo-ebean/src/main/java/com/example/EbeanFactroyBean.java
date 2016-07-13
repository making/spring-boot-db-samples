package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.ServerConfig;

@Component
public class EbeanFactroyBean implements FactoryBean<EbeanServer>, EnvironmentAware {

    private Properties properties = new Properties();
    
    @Override
    public EbeanServer getObject() throws Exception {

        ServerConfig config = new ServerConfig();
        config.setName("db");
        config.loadFromProperties(properties);
        config.loadTestProperties();
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

    @Override
    public void setEnvironment(Environment environment) {

        MutablePropertySources propertySources = ((AbstractEnvironment) environment).getPropertySources();

        List<MapPropertySource> props = new ArrayList<>();
        for (PropertySource<?> propertySource : propertySources) {
            if (propertySource instanceof MapPropertySource) {
                props.add(0, (MapPropertySource) propertySource);
            }
        }
        for (MapPropertySource propertySource : props) {
            properties.putAll(propertySource.getSource());
        }
    }

}
