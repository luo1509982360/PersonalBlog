package com.lyx.service.impl;

import com.lyx.bean.Tag;
import com.lyx.bean.dto.TagByGroupAndOrder;
import com.lyx.dao.TagMapper;
import com.lyx.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author The setting sun
 * @version 1.0
 * @title: TagServiceImpl
 * @description: TODO
 * @date 2022/5/14 15:36
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;

    @Override
    public Tag getTag(Integer id) {
        Tag Tag = tagMapper.getTag(id);

        return Tag;
    }

    @Override
    public Tag getTagByName(String name) {
        Tag Tag = tagMapper.getTagByName(name);

        return Tag;
    }

    @Override
    public List<Tag> listTag() {
        List<Tag> Tags = tagMapper.listTag();

        return Tags;
    }

    @Override
    public List<Tag> listTagByIds(String ids) {
        List<Tag> tags = tagMapper.listTagByIds(ids);

        return tags;
    }

    @Override
    public List<TagByGroupAndOrder> listTagByGroupAndOrder(Integer limit) {
        List<TagByGroupAndOrder> tags = tagMapper.listTagByGroupAndOrder(limit);

        return tags;
    }

    @Override
    public List<TagByGroupAndOrder> listTagAllByGroupAndOrder() {
        List<TagByGroupAndOrder> tags = tagMapper.listTagAllByGroupAndOrder();

        return tags;
    }

    @Transactional
    @Override
    public int saveTag(Tag Tag) {
        return tagMapper.saveTag(Tag);
    }

    @Transactional
    @Override
    public int updateTag(Tag Tag) {
        return tagMapper.updateTag(Tag);
    }

    @Transactional
    @Override
    public int deleteTag(Integer id) {
        int count = tagMapper.deleteTag(id);
        tagMapper.deleteTagAndBlog(id);
        return count;
    }
}
