package com.lyx.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.*;

/**
 * @author The setting sun
 * @version 1.0
 * @title: Blog
 * @description: TODO
 * @date 2022/5/13 14:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_blog")
public class Blog {
    @TableId(type = IdType.AUTO)
    private Integer id;

    //    博客标题
    private String title;

    //    博客描述
    private String description;

    //    博客内容
    private String content;

    //    封面图片
    private String coverPicture;

    //    标记，原创/转载/翻译
    private String flag;

    //    浏览次数
    private Integer views;

    //    是否开启赞赏
    private boolean appreciationEnable;

    //    转载声明是否开启
    private boolean shareStatementEnable;

    //    留言是否开启
    private boolean commentEnable;

    //    发布状态
    private boolean published;

    //    是否推荐
    private boolean recommendEnable;

    //    创建时间
    private Date createDate;
    private String CreateDateStr;

    //    更新时间
    private Date updateDate;
    private String UpdateDateStr;

    private Type type;

    private List<Tag> tags = new ArrayList<>();
    private String tagIds;
    private String oldTagIds;

    private User user;

    private List<Comment> comments = new ArrayList<>();

    public void initIds() {
        this.tagIds = tagsToIds(this.getTags());
    }

    private String tagsToIds(List<Tag> tags) {
        if (!tags.isEmpty()) {
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for (Tag tag : tags) {
                if (flag) {
                    ids.append(",");
                } else {
                    flag = true;
                }
                ids.append(tag.getId());
            }

            return ids.toString();
        } else {
            return tagIds;
        }
    }

    public Blog(Integer id) {
        this.id = id;
    }

    public Blog(String title, boolean recommendEnable, Type type) {
        this.title = title;
        this.recommendEnable = recommendEnable;
        this.type = type;
    }

    public Blog(Integer id, String title, String content, String coverPicture, String flag, Integer views, boolean appreciationEnable, boolean shareStatementEnable, boolean commentEnable, boolean published, boolean recommendEnable, Date createDate, Timestamp updateDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.coverPicture = coverPicture;
        this.flag = flag;
        this.views = views;
        this.appreciationEnable = appreciationEnable;
        this.shareStatementEnable = shareStatementEnable;
        this.commentEnable = commentEnable;
        this.published = published;
        this.recommendEnable = recommendEnable;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
