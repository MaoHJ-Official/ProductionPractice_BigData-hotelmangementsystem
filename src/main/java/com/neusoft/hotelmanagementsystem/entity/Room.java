package com.neusoft.hotelmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
//@Setter
//@Getter
//@ToString
//@EqualsAndHashCode
// @Data = setter + getter + toString + equals + hashcode +  noargscons（不额外提供其他构造函数的时候）
@Data
@Builder //提供了一种创建对象的方式
public class Room {
    private Integer roomId;

    private Integer status;

    private Integer roomType;
}
