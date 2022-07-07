package com.narola.spring;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "com.narola.spring")
@EnableWebMvc
@PropertySource("classpath:db-config.properties")
@EnableTransactionManagement
@EnableJpaRepositories
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private Environment env;

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        Map<String, Object> jpaPropertiesMap = new HashMap<>();
        jpaPropertiesMap.put(AvailableSettings.JPA_JDBC_DRIVER, env.getProperty("db.driver"));
        jpaPropertiesMap.put(AvailableSettings.JPA_JDBC_USER, env.getProperty("db.user"));
        jpaPropertiesMap.put(AvailableSettings.JPA_JDBC_PASSWORD, env.getProperty("db.password"));
        jpaPropertiesMap.put(AvailableSettings.JPA_JDBC_URL, env.getProperty("db.url"));
        jpaPropertiesMap.put(AvailableSettings.HBM2DDL_DATABASE_ACTION, env.getProperty(AvailableSettings.HBM2DDL_DATABASE_ACTION));
        //jpaPropertiesMap.put(AvailableSettings.HBM2DDL_AUTO, env.getProperty(AvailableSettings.HBM2DDL_AUTO));
        jpaPropertiesMap.put(AvailableSettings.SHOW_SQL, env.getProperty("hibernate.show_sql"));
        jpaPropertiesMap.put(AvailableSettings.FORMAT_SQL, env.getProperty("hibernate.format_sql"));

        LocalContainerEntityManagerFactoryBean localEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localEntityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        localEntityManagerFactoryBean.setPersistenceUnitName("persistenceUnit");
        localEntityManagerFactoryBean.setPackagesToScan("com.narola.spring");
        localEntityManagerFactoryBean.setJpaPropertyMap(jpaPropertiesMap);
        return localEntityManagerFactoryBean;
    }
    @Bean(name = "transactionManager")
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
