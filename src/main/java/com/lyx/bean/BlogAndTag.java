package com.lyx.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

/**
 * @author The setting sun
 * @version 1.0
 * @title: BlogAndTag
 * @description: TODO
 * @date 2022/5/15 16:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_blog_tag")
public class BlogAndTag {
    @TableId(type = IdType.AUTO)
    private int id;

    private Integer blogId;

    private Integer tagId;

    public BlogAndTag(Integer blogId, Integer tagId) {
        this.blogId = blogId;
        this.tagId = tagId;
    }
}
