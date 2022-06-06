package com.lyx;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyx.bean.*;
import com.lyx.dao.*;
import com.lyx.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
import java.util.*;

@SpringBootTest
class PersonalBlogApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Autowired
    TypeMapper typeMapper;
    @Autowired
    TagMapper tagMapper;
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    BlogService blogService;
    @Autowired
    CommentService commentService;
    @Autowired
    BlogrollService blogrollService;

    @Test
    void contextLoads() {
//        List<Tag> tags = new ArrayList<Tag>();
//        tags.add(new Tag(7l, "cs"));
//        tags.add(new Tag(8l, "cs"));
//        tags.add(new Tag(9l, "cs"));
//        blogService.saveBlog(new Blog(null, "测试3", "content1", null, null, null, true, true, true, true, true, null, null, new Type(23l, "cs"), tags, new User(1l), null));

//        commentService.saveComment(new Comment(null, "cs", "cs", "cs", "cs", new Date(), null, new Blog(19), null, new Comment(1)));
//        System.out.println(blogMapper.listBlogCreateDate());
//        System.out.println(blogService.archivesBlog());
//        System.out.println(blogrollService.listBlogroll());

        PageHelper.startPage(1, 5);
        ArrayList<Object> list = new ArrayList<>();
        list.add("第一");
        list.add("第二");
        list.add("第三");
        list.add("第四");
        list.add("第五");
        PageInfo pageInfo = new PageInfo(list, 5);
        System.out.println(pageInfo);
    }

    @Test
    void contextLoads1() throws NoSuchMethodException {
//        blogService.deleteBlog(5l);
//        System.out.println(blogService.listBlog(null));
//        List<Tag> tags = tagMapper.listTagByIds("7,8,9");
//        System.out.println(tags);
//        System.out.println(blogService.listBlog());

//        String str2 = "1,2,3,";
//        String[] strs2 = str2.split("\\,");
//        for (int i = 0; i < strs2.length; i++) {
//            System.out.println(strs2[i]);
//        }

//        System.out.println(typeMapper.listTypeByGroup(5));
//        System.out.println(blogService.listBlogByPage());
//        blogService.saveBlog(new Blog());
//        User user = userMapper.findByUsernameAndPassword("1", "1");
//        List list = new ArrayList();
//        System.out.println(list.get(1));
        Class<User> clazz = User.class;
        Method method = clazz.getMethod("method");
    }
}
