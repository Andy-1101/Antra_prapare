package com.example.mvchomework;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnitUtil;
import javax.sql.DataSource;
import java.util.Properties;

public class MysqlConnection implements Cloneable{
    private DataSource getDataSource(){
        final MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("$Mjy960624");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/exercise1");
        return dataSource;
    }

    private Properties getProperties(){
        final Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        properties.put("hibernate.show_sql", "true");
        return properties;
    }

    private EntityManagerFactory entityManagerFactory(DataSource dataSource, Properties hibernateProperties) {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com/example/mvchomework");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(hibernateProperties);
        em.setPersistenceUnitName("demo-unit");
        em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        em.afterPropertiesSet();
        return em.getObject();
    }


    private volatile static  EntityManager conn;

    public static EntityManager getInstance(){
        if (conn == null){
            MysqlConnection ormConfig = new MysqlConnection();
            DataSource dataSource = ormConfig.getDataSource();
            Properties properties = ormConfig.getProperties();
            EntityManagerFactory entityManagerFactory = ormConfig.entityManagerFactory(dataSource,properties);
            conn = entityManagerFactory.createEntityManager();
            PersistenceUnitUtil unitUtil = entityManagerFactory.getPersistenceUnitUtil();
        }

        return conn;
    }

    @Override
    public Object clone(){
        throw new RuntimeException();
    }

}
