/**
 * @Project Name :  base
 * @Package Name :  com.agile.config
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-23 7:22 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile.config;

import com.agile.config.properties.JwtProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author :  panduanduan
 * @Description :  属性自动装配
 * @Creation Date:  2018-01-23 7:22 PM
 */
@Configuration
@EnableConfigurationProperties({JwtProperties.class})
public class OrientPropertiesConfig {
}