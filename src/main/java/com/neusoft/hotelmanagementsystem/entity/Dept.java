package com.neusoft.hotelmanagementsystem.entity;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
//@Setter
//@Getter
//@ToString
//@EqualsAndHashCode
// @Data = setter + getter + toString + equals + hashcode +  noargscons（不额外提供其他构造函数的时候）
@Data
@Builder //提供了一种创建对象的方式
public class Dept {

    private Integer deptId;

    private String deptName;

    private Integer status;

    private List<Emp> empList; //根据对应关系，在对应的实体类中增加属性
//    一对一的关系 - 增加的是实例对象本身
//    一对多的关系 - 增加的是实例对象的集合
}
