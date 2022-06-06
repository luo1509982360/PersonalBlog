package com.lyx.service;

import com.lyx.bean.Tag;
import com.lyx.bean.dto.TagByGroupAndOrder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author The setting sun
 * @version 1.0
 * @title: TagService
 * @description: TODO
 * @date 2022/5/14 15:36
 */
@Service
public interface TagService {
    Tag getTag(Integer id);

    Tag getTagByName(String name);

    List<Tag> listTag();

    List<Tag> listTagByIds(String ids);

    List<TagByGroupAndOrder> listTagByGroupAndOrder(Integer limit);

    List<TagByGroupAndOrder> listTagAllByGroupAndOrder();

    int saveTag(Tag tag);

    int updateTag(Tag tag);

    int deleteTag(Integer id);
}
