package com.lyx.dao;

import com.lyx.bean.Type;
import com.lyx.bean.dto.TypeByGroupAndOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author The setting sun
 * @version 1.0
 * @title: TypeMapper
 * @description: TODO
 * @date 2022/5/14 15:47
 */
@Mapper
public interface TypeMapper {
    Type getType(Integer id);

    Type getTypeByName(String name);

    List<Type> listType();

    List<TypeByGroupAndOrder> listTypeByGroupAndOrder(Integer limit);

    List<TypeByGroupAndOrder> listAllTypeByGroupAndOrder();

    int saveType(Type type);

    int updateType(Type type);

    int deleteType(Integer id);
}
