/**
 * @Project Name :  base
 * @Package Name :  com.agile
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-22 4:43 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
                       _oo0oo_
                      o8888888o
                      88" . "88
                      (| -_- |)
                      0\  =  /0
                    ___/`---'\___
                  .' \\|     |// '.
                 / \\|||  :  |||// \
                / _||||| -:- |||||- \
               |   | \\\  -  /// |   |
               | \_|  ''\---/''  |_/ |
               \  .-\__  '-'  ___/-. /
             ___'. .'  /--.--\  `. .'___
          ."" '<  `.___\_<|>_/___.' >' "".
         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
         \  \ `_.   \_ __\ /__ _/   .-` /  /
     =====`-.____`.___ \_____/___.-`___.-'=====
                       `=---='


     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

               佛祖保佑         永无BUG


*/
@SpringBootApplication
@EnableScheduling
public class OrientApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrientApplication.class, args);
    }
}