package com.hos.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

/**
 * Author: DiBin
 * Date: Created in 2021/3/23 19:58
 * Description: Database Connection Configuration
 */

@Configuration
@MapperScan(basePackages = HosDataSourceConfig.PACKAGE,
        sqlSessionFactoryRef = "HosSqlSessionFactory")
public class HosDataSourceConfig {

    static final String PACKAGE = "com.hos.**";

    /**
     * Description: get data source by config
     * @return
     * @throws IOException
     */
    @Bean(name = "HosDataSource")
    @Primary
    public DataSource hosDataSource() throws IOException {
        // get data source info
        ResourceLoader loader = new DefaultResourceLoader();
        InputStream inputStream = loader.getResource("classpath:application.properties")
                .getInputStream();
        Properties properties = new Properties();
        properties.load(inputStream);
        Set<Object> keys = properties.keySet();
        Properties dsproperties = new Properties();
        for (Object key : keys) {
            if (key.toString().startsWith("datasource")) {
                dsproperties.put(key.toString().replace("datasource.", ""), properties.get(key));
            }
        }
        // generate data source
        HikariDataSourceFactory factory = new HikariDataSourceFactory();
        factory.setProperties(dsproperties);
        inputStream.close();
        return factory.getDataSource();
    }

    /**
     * Description: get sql session factory
     * @param phoenixDataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "HosSqlSessionFactory")
    @Primary
    public SqlSessionFactory hosSqlSessionFactory(
            @Qualifier("HosDataSource") DataSource phoenixDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(phoenixDataSource);
        // set mybatis config
        ResourceLoader loader = new DefaultResourceLoader();
        String resource = "classpath:mybatis-config.xml";
        factoryBean.setConfigLocation(loader.getResource(resource));
        // get sql session factory instance
        factoryBean.setSqlSessionFactoryBuilder(new SqlSessionFactoryBuilder());
        return factoryBean.getObject();
    }

}
