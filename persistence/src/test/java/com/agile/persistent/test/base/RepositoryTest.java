/**
 * @Project Name :  mainserver
 * @Package Name :  com.agile.persistent.test.base
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-29 9:12 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile.persistent.test.base;

import com.agile.OrientApplication;
import org.apache.ibatis.session.SqlSession;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author :  panduanduan
 * @Description :  repository test base class
 * @Creation Date:  2018-01-29 9:12 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {OrientApplication.class})
//@Transactional
//@Rollback
public class RepositoryTest {

    @Autowired
    protected SqlSession sqlSession;
}