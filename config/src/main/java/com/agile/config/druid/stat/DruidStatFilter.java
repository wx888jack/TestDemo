/**
 * @Project Name :  base
 * @Package Name :  com.agile.config.druid.actuator.stat
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-23 1:37 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile.config.druid.stat;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @author :  panduanduan
 * @Description :  忽略静态资源
 * @Creation Date:  2018-01-23 1:37 PM
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
        }
)
public class DruidStatFilter extends WebStatFilter {
}