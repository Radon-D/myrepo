package example.advanced.wiring.env.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

@Configuration
@Profile("dev")
public class DataSourceConfig {

    // 配置一个嵌入式h2数据库
    @Bean
    @Profile("dev")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .addScript("classpath:datasource/schema.sql")
                .addScript("classpath:datasource/test-data.sql")
                .build();
    }

    // 通过JNDI获取DataSource
//    @Bean
//    public DataSource dataSource() {
//        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
//        jndiObjectFactoryBean.setJndiName("jdbc/myDS");
//        jndiObjectFactoryBean.setResourceRef(true);
//        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
//        return (DataSource) jndiObjectFactoryBean.getObject();
//    }

    // 通过DBCP连接池配置DataSource
//    @Bean(destroyMethod = "close")
//    public DataSource dataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setUrl("jdbc:h2:tcp://dbserver/~/test");
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("password");
//        dataSource.setInitialSize(20);
//        dataSource.setMaxActive(30);
//        return dataSource;
//    }

}
