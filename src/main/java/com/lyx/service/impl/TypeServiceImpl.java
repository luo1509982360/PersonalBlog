package com.lyx.service.impl;

import com.lyx.bean.Type;
import com.lyx.bean.dto.TypeByGroupAndOrder;
import com.lyx.dao.TypeMapper;
import com.lyx.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author The setting sun
 * @version 1.0
 * @title: TypeServiceImpl
 * @description: TODO
 * @date 2022/5/14 15:36
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeMapper typeMapper;

    @Override
    public Type getType(Integer id) {
        Type type = typeMapper.getType(id);

        return type;
    }

    @Override
    public Type getTypeByName(String name) {
        Type type = typeMapper.getTypeByName(name);

        return type;
    }

    @Override
    public List<Type> listType() {
        List<Type> types = typeMapper.listType();

        return types;
    }

    @Override
    public List<TypeByGroupAndOrder> listTypeByGroupAndOrder(Integer limit) {
        List<TypeByGroupAndOrder> types = typeMapper.listTypeByGroupAndOrder(limit);

        return types;
    }

    @Override
    public List<TypeByGroupAndOrder> listAllTypeByGroupAndOrder() {
        List<TypeByGroupAndOrder> types = typeMapper.listAllTypeByGroupAndOrder();

        return types;
    }

    @Transactional
    @Override
    public int saveType(Type type) {
        return typeMapper.saveType(type);
    }

    @Transactional
    @Override
    public int updateType(Type type) {
        return typeMapper.updateType(type);
    }

    @Transactional
    @Override
    public int deleteType(Integer id) {
        return typeMapper.deleteType(id);
    }
}
