package com.lyx.bean.dto;

import lombok.*;

/**
 * @author The setting sun
 * @version 1.0
 * @title: TagAndCount
 * @description: TODO
 * @date 2022/5/20 14:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagByGroupAndOrder {
    private Integer id;

    private String name;

    private Integer count;
}
