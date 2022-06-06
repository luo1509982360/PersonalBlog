package com.lyx.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

/**
 * @author The setting sun
 * @version 1.0
 * @title: Blogroll
 * @description: TODO
 * @date 2022/5/26 16:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_blogroll")
public class Blogroll {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String blogTitle;

    private String blogUrl;

    private String blogImg;
}
