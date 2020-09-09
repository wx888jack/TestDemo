/**
 * @Project Name :  portal
 * @Package Name :  com.agile.portal.config
 * @Description :
 * @author :  panduanduan
 * @Creation Date:  2017-12-26 4:33 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author :  panduanduan
 * @Description :  契约初始化,加入springfox-swagger-ui依赖后，访问http://ip:port/contextName/swagger-ui.html
 * @Creation Date:  2017-12-26 4:33 PM
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.agile"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Orient Restful API")
                .description("前后端契约描述")
                .termsOfServiceUrl("http://www.agile.tdm.com/")
                .version("1.0")
                .build();
    }
}