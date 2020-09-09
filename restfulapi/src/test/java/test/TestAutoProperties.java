/**
 * @Project Name :  base
 * @Package Name :  com.agile.test
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-23 9:57 AM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package test;

import com.agile.OrientApplication;
import com.agile.config.properties.JwtProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author :  huangximing
 * @Description :  测试属性类自动装载
 * @Creation Date:  2018-01-23 9:57 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {OrientApplication.class})
public class TestAutoProperties {

    @Autowired
    JwtProperties jwtProperties;


    @Test
    public void testJwtProperties() {
        /*System.err.println("TestAutoProperties.testJwtProperties()=" + jwtProperties);
        Assert.assertEquals("15852505449198803161988081819891", jwtProperties.getSalt());*/

    }


}