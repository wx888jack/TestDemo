/**
 * @Project Name :  backtemplate
 * @Package Name :  test
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-26 2:53 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile.persistent.test.system;

import com.agile.persistent.test.base.RepositoryTest;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 * @author :  panduanduan
 * @Description :  test dep crud
 * @Creation Date:  2018-01-26 2:53 PM
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUserRepository extends RepositoryTest {
//
//    SysUserMapper sysUserMapper;
//
//    @Before
//    public void setUp() {
//        sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
//    }
//
//    /**
//     * 测试查询数据
//     */
//    @Test
//    public void test001() {
//        List<SysUser> count = sysUserMapper.selectAll();
//        Assert.assertEquals(0, count.size());
//    }
//
//    /**
//     * 测试插入数据
//     */
//    @Test
//    public void test002() {
//        SysUser sysUserPO = new SysUser();
//        sysUserPO.setUserName("15852505449");
//        sysUserMapper.insert(sysUserPO);
//        Assert.assertNotNull(sysUserPO.getId());
//    }
//
//    /**
//     * 测试更新数据
//     */
//    @Test
//    public void test003() {
//        Example example = new Example(SysUser.class);
//        example.createCriteria().andEqualTo("userName", "15852505449");
//        SysUser sysUserPO = sysUserMapper.selectOneByExample(example);
//        Assert.assertNotNull(sysUserPO);
//        sysUserPO.setPassword("123456");
//        sysUserMapper.updateByPrimaryKey(sysUserPO);
//    }
//
//    /**
//     * 测试删除数据
//     */
//    @Test
//    public void test004() {
//        Example example = new Example(SysUser.class);
//        example.createCriteria().andEqualTo("userName", "15852505449");
//        SysUser sysUserPO = sysUserMapper.selectOneByExample(example);
//        Assert.assertNotNull(sysUserPO);
//        sysUserMapper.delete(sysUserPO);
//        int count = sysUserMapper.selectCount(null);
//        Assert.assertEquals(0, count);
//    }
}