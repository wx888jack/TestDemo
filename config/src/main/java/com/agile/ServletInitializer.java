/**
 * @Project Name :  base
 * @Package Name :  com.agile
 * @Description : 替代web.xml
 * @author :  panduanduan
 * @Creation Date:  2018-01-22 4:51 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @Description  :  for war
 * @author       :  panduanduan
 * @Creation Date:  2018-01-22 4:51 PM
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OrientApplication.class);
    }

}