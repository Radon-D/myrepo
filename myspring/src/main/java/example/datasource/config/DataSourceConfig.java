package example.datasource.config;

import example.datasource.repository.JdbcSpitterRepository;
import example.datasource.repository.SpitterRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "example.datasource.config")
public class DataSourceConfig {

    // JNDI方式创建数据源
//    @Bean
//    public JndiObjectFactoryBean dataSource() {
//        JndiObjectFactoryBean jndiObjectFB = new JndiObjectFactoryBean();
//        jndiObjectFB.setJndiName("jdbc/myDatabase");
//        jndiObjectFB.setResourceRef(true);
//        jndiObjectFB.setProxyInterface(javax.sql.DataSource.class);
//        return jndiObjectFB;
//    }

    // DBCP数据源
//    @Bean
//    public BasicDataSource datasource() {
//        BasicDataSource basicDataSource = new BasicDataSource();
//        basicDataSource.setDriverClassName("org.h2.Driver");
//        basicDataSource.setUrl("jdbc:h2:tcp://localhost/~/spitter");
//        basicDataSource.setUsername("sa");
//        basicDataSource.setPassword("");
//        basicDataSource.setInitialSize(5);
//        basicDataSource.setMaxActive(10);
//        return basicDataSource;
//    }

    // DriverManager数据源
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        driverManagerDataSource.setDriverClassName("org.h2.Driver");
//        driverManagerDataSource.setUrl("jdbc:h2:tcp://localhost/~/spitter");
//        driverManagerDataSource.setUsername("sa");
//        driverManagerDataSource.setPassword("");
//        return driverManagerDataSource;
//    }

    // 嵌入式H2数据源
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:/datasource.schema.sql")
                .addScript("classpath:/datasource.test-data.sql")
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public SpitterRepository spitterRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcSpitterRepository(jdbcTemplate);
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public SpitterRepository spitterRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        return new JdbcSpitterRepository(namedParameterJdbcTemplate);
    }

}