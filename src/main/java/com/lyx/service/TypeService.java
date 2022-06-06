package com.lyx.service;

import com.lyx.bean.Type;
import com.lyx.bean.dto.TypeByGroupAndOrder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author The setting sun
 * @version 1.0
 * @title: TypeService
 * @description: TODO
 * @date 2022/5/14 15:36
 */
@Service
public interface TypeService {
    Type getType(Integer id);

    Type getTypeByName(String name);

    List<Type> listType();

    List<TypeByGroupAndOrder> listTypeByGroupAndOrder(Integer limit);

    List<TypeByGroupAndOrder> listAllTypeByGroupAndOrder();

    int saveType(Type type);

    int updateType(Type type);

    int deleteType(Integer id);
}
