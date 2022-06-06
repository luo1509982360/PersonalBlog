package com.lyx.service;

import com.lyx.bean.Blogroll;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author The setting sun
 * @version 1.0
 * @title: BlogrollService
 * @description: TODO
 * @date 2022/5/26 16:21
 */
@Service
public interface BlogrollService {
    Blogroll getBlogroll(Integer id);

    List<Blogroll> listBlogroll();

    int saveBlogroll(Blogroll blogroll);

    int updateBlogroll(Blogroll blogroll);

    int deleteBlogroll(Integer id);
}
