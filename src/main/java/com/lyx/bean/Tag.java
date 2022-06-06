package com.lyx.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author The setting sun
 * @version 1.0
 * @title: Tag
 * @description: TODO
 * @date 2022/5/13 15:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_tag")
public class Tag {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private List<Blog> blogs = new ArrayList<>();

    public Tag(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
