package com.lyx.service.impl;

import com.lyx.bean.Blogroll;
import com.lyx.dao.BlogrollMapper;
import com.lyx.service.BlogrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author The setting sun
 * @version 1.0
 * @title: BlogrollServiceImpl
 * @description: TODO
 * @date 2022/5/26 16:21
 */
@Service
public class BlogrollServiceImpl implements BlogrollService {
    @Autowired
    BlogrollMapper blogrollMapper;

    @Override
    public Blogroll getBlogroll(Integer id) {
        Blogroll blogroll = blogrollMapper.getBlogroll(id);

        return blogroll;
    }

    @Override
    public List<Blogroll> listBlogroll() {
        List<Blogroll> blogrolls = blogrollMapper.listBlogroll();

        return blogrolls;
    }

    @Transactional
    @Override
    public int saveBlogroll(Blogroll blogroll) {
        return blogrollMapper.saveBlogroll(blogroll);
    }

    @Transactional
    @Override
    public int updateBlogroll(Blogroll blogroll) {
        return blogrollMapper.updateBlogroll(blogroll);
    }

    @Transactional
    @Override
    public int deleteBlogroll(Integer id) {
        return blogrollMapper.deleteBlogroll(id);
    }
}
