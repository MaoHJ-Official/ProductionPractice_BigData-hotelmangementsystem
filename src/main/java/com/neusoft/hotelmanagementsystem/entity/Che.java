package com.neusoft.hotelmanagementsystem.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Che {
    private Integer OrderId;
    private Integer RoomId;

    private String CusName;

    private Date CheckinDate;

    private Date LeaveDate;



    private Integer Status;


}
