/**
 * @Project Name :  mainserver
 * @Package Name :  com.agile.common.mybatis
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-26 11:01 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile.config.mybatis;

import com.github.pagehelper.PageHelper;
import com.agile.common.mybatis.BaseOrientMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * @author :  panduanduan
 * @Description :  config mybatis mapperScanner
 * @Creation Date:  2018-01-26 11:01 PM
 */
@Configuration
public class MyBatisMapperScannerConfig {

    @Bean
    public PageHelper pageHelper() {
        Properties prop = new Properties();
        prop.setProperty("dialect", "mysql");
        prop.setProperty("supportMethodsArguments", "true");
        prop.setProperty("params", "pageNum=pageNum;pageSize=pageSize;");
        PageHelper pagePlugin = new PageHelper();
        pagePlugin.setProperties(prop);
        return pagePlugin;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.agile.persistent.mapper");
        mapperScannerConfigurer.setMarkerInterface(BaseOrientMapper.class);
        Properties properties = new Properties();
//        properties.setProperty("ORDER", "BEFORE");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }

}