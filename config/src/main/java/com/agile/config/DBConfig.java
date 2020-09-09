/**
 * @Project Name :  base
 * @Package Name :  com.agile.config
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-22 5:46 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.agile.config.druid.actuator.endpoint.DruidDataSourceMvcEndpoint;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author :  panduanduan
 * @Description :  采用druid初始化数据库连接
 * @Creation Date:  2018-01-22 5:46 PM
 */
@Configuration
@Import(DruidDataSourceMvcEndpoint.class)
@EnableTransactionManagement
@EnableJpaAuditing
public class DBConfig {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}