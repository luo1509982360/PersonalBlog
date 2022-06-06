package com.lyx.bean.dto;

import lombok.*;

/**
 * @author The setting sun
 * @version 1.0
 * @title: TypeAndCount
 * @description: TODO
 * @date 2022/5/20 14:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeByGroupAndOrder {
    private Integer id;

    private String name;

    private Integer count;
}
