/**
 * @Project Name :  mainserver
 * @Package Name :  com.agile.common.mybatis
 * @Description :  TODO
 * @author :  panduanduan
 * @Creation Date:  2018-01-26 9:53 PM
 * @ModificationHistory Who    When    What
 * --------  ---------  --------------------------
 */
package com.agile.common.mybatis;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author :  ximing huang
 * @Description :  mapper 基类
 * @Creation Date:  2018-01-26 9:53 PM
 */
public interface BaseOrientMapper<T> extends Mapper<T>, IdsMapper<T>,ConditionMapper<T> {

}
