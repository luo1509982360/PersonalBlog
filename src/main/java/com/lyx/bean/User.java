package com.lyx.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.util.*;

/**
 * @author The setting sun
 * @version 1.0
 * @title: User
 * @description: TODO
 * @date 2022/5/13 15:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String nickname;

    private String username;

    private String password;

    private String email;

    private String avatar;

    private Integer type;

    private Date createDate;

    private Date updateDate;

    private List<Blog> blogs = new ArrayList<>();

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String nickname, String username, String password, String email, String avatar, Integer type, Date createDate, Date updateDate) {
        this.id = id;
        this.nickname = nickname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.type = type;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
