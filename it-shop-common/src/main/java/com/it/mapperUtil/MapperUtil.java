package com.it.mapperUtil;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用Mapper
 */
public interface MapperUtil<T> extends Mapper<T>, MySqlMapper<T> {
}
