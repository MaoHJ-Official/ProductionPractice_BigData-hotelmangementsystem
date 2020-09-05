package com.neusoft.hotelmanagementsystem.entity;


import lombok.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Custom {

    private Integer orderId;

    private String cusName;

    private Integer cusPhone;

    private Date cDate;

    private Date leaveDate;

    private Integer roomType;

    private Integer roomId;
}

