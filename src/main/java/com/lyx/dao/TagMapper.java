package com.lyx.dao;

import com.lyx.bean.Tag;
import com.lyx.bean.dto.TagByGroupAndOrder;
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
public interface TagMapper {
    Tag getTag(Integer id);

    Tag getTagByName(String name);

    List<Tag> listTagByIds(String ids);

    List<TagByGroupAndOrder> listTagByGroupAndOrder(Integer limit);

    List<TagByGroupAndOrder> listTagAllByGroupAndOrder();

    List<Tag> listTag();

    int saveTag(Tag tag);

    int updateTag(Tag tag);

    int deleteTag(Integer id);

    int deleteTagAndBlog(Integer id);
}
