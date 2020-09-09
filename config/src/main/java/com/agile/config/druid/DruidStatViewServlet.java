/**
 * @Project Name :  base
 * @Package Name :  com.agile.config.druid
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-23 1:39 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile.config.druid;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @author :  panduanduan
 * @Description :  监控数据源状态，访问地址http://ip:port/contextPath/druid
 * @Creation Date:  2018-01-23 1:39 PM
 */
@WebServlet(urlPatterns = "/druid/*",
        initParams = {
                @WebInitParam(name = "loginUsername", value = "agile"),// 用户名
                @WebInitParam(name = "loginPassword", value = "tdm@cssrc8"),// 密码
                @WebInitParam(name = "resetEnable", value = "false")// 禁用HTML页面上的“Reset All”功能
        })
public class DruidStatViewServlet extends StatViewServlet {
}
