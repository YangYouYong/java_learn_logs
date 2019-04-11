package com.vechain.mobile.core.base;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 *
 * BaseMapper
 *
 * @name BaseMapper
 * @version 1.0
 * @author nico
 */
public interface Mapper<T> extends BaseMapper<T>, ConditionMapper<T>, IdsMapper<T>, InsertListMapper<T> {

}
