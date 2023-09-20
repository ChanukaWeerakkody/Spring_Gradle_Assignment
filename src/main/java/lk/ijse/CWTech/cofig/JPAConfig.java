package lk.ijse.CWTech.cofig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author : Chanuka Weerakkody
 * @since : 20.1.1
 **/
@Configuration
@EnableJpaRepositories(basePackages = "lk.ijse.CWTech.repo")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class JPAConfig {
    /*@Autowired
    Environment env;

    @Autowired
    public JPAConfig(Environment env) {
        System.out.println("Started JPAConfig");
        this.env = env;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds){
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(ds);//Connection
        bean.setPackagesToScan(env.getRequiredProperty("entity.package.name"));//location
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);
        vendorAdapter.setDatabase(Database.MYSQL);
        bean.setJpaVendorAdapter(vendorAdapter);//Vendor(hibernate)
        bean.setJpaPropertyMap(hibernateConfigs()); // Hibernate property map

        return bean;
    }

    @Bean
    public DataSource dataSource() {
        *//*DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("my.app.driverclassname"));
        dataSource.setUrl(env.getRequiredProperty("my.app.url"));
        dataSource.setUsername(env.getRequiredProperty("my.app.username"));
        dataSource.setPassword(env.getRequiredProperty("my.app.password"));

        return dataSource;*//*
        //return (DataSource) new JndiTemplate().lookup("java:comp/env/jdbc/pool");

        DriverManagerDataSource dmd = new DriverManagerDataSource();

        dmd.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dmd.setUrl(env.getProperty("spring.datasource.url"));
        dmd.setUsername(env.getProperty("spring.datasource.username"));
        dmd.setPassword(env.getProperty("spring.datasource.password"));
        return dmd;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }

    // Load Hibernate Properties
    private Map<String, String> hibernateConfigs() {
        Map<String, String> hbConfigs = new HashMap<>();
        hbConfigs.put("spring.jpa.hibernate.ddl-auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        hbConfigs.put("spring.jpa.show-sql", env.getProperty("spring.jpa.show-sql"));
        hbConfigs.put("spring.jpa.properties.hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
        hbConfigs.put("spring.jpa.properties.hibernate.format_sql", env.getProperty("spring.jpa.properties.hibernate.format_sql"));
        return hbConfigs;
    }*/

    @Autowired
    Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds, JpaVendorAdapter va){
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setJpaVendorAdapter(va);//Vendor(hibernate)
        bean.setDataSource(ds);//Connection
        bean.setPackagesToScan(env.getRequiredProperty("entity.package.name"));//location
        return bean;
    }

    @Bean
    public DataSource dataSource() throws NamingException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getRequiredProperty("my.app.url"));
        dataSource.setUsername(env.getRequiredProperty("my.app.username"));
        dataSource.setPassword(env.getRequiredProperty("my.app.password"));
        dataSource.setDriverClassName(env.getRequiredProperty("my.app.driverclassname"));
        return dataSource;
        /*return (DataSource) new JndiTemplate().lookup("java:comp/env/jdbc/pool");*/
    }


    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter vendor=new HibernateJpaVendorAdapter();
        vendor.setDatabasePlatform(env.getRequiredProperty("my.app.dialect"));
        vendor.setDatabase(Database.MYSQL);
        vendor.setShowSql(true);
        vendor.setGenerateDdl(true);
        return vendor;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }
}
