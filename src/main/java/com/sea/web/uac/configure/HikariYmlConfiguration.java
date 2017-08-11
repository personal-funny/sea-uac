package com.sea.web.uac.configure;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by chris on 17-7-28.
 */
@Configuration
public class HikariYmlConfiguration {
  @Value("${spring.datasource.hikari.pool-name}")
  private String poolName;
  @Value("${spring.datasource.url}")
  private String jdbcUrl;
  @Value("${spring.datasource.driver-class-name}")
  private String driverClass;
  @Value("${spring.datasource.username}")
  private String username;
  @Value("${spring.datasource.password}")
  private String password;
  @Value("${spring.datasource.hikari.connectionTestQuery}")
  private String connectionTestQuery;


  @Bean
  public DataSource dataSource() {
    HikariConfig configuration = new HikariConfig();
    configuration.setPoolName(poolName);
    configuration.setMinimumIdle(5);
    configuration.setMaximumPoolSize(25);
    configuration.setConnectionTimeout(30000);
    configuration.setIdleTimeout(30000);
    configuration.setJdbcUrl(jdbcUrl);
    configuration.setDriverClassName(driverClass);
    configuration.setConnectionTestQuery(connectionTestQuery);
    configuration.addDataSourceProperty("user", username);
    configuration.addDataSourceProperty("password", password);
    return new HikariDataSource(configuration);
  }
}
