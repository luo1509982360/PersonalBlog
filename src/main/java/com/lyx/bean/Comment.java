package com.lyx.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author The setting sun
 * @version 1.0
 * @title: Comment
 * @description: TODO
 * @date 2022/5/13 15:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_comment")
public class Comment {
    @TableId(type = IdType.AUTO)
    private Integer id;

//    昵称
    private String nickname;

//    邮箱
    private String email;

//    留言内容
    private String content;

//    头像
    private String avatar;

//    创建时间
    private Date createDate;
    private String createDateStr;

    private Blog blog;

    private Comment parentComment;

    public Comment(Integer id) {
        this.id = id;
    }

    public Comment(Integer id, String nickname, String email, String content, String avatar, Date createDate) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.content = content;
        this.avatar = avatar;
        this.createDate = createDate;
    }
}
