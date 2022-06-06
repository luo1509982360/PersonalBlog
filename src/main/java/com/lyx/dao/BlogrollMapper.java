package com.lyx.dao;

import com.lyx.bean.Blogroll;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author The setting sun
 * @version 1.0
 * @title: BlogrollMapper
 * @description: TODO
 * @date 2022/5/26 14:38
 */
@Mapper
public interface BlogrollMapper {
    Blogroll getBlogroll(Integer id);

    List<Blogroll> listBlogroll();

    int saveBlogroll(Blogroll blogroll);

    int updateBlogroll(Blogroll blogroll);

    int deleteBlogroll(Integer id);
}
