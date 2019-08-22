package com.yx.emm504.Model.maintain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MaintainInfo implements Serializable{
    private String productId;		//维修编号		
    private String maintainStatus;	//维修状态
    private String maintainNote;	//维修记录
    private String checkNote;		//检测记录
    private String maintainMan;		//维修工人
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date processDate;		//检测日期
    private String usedParts;		//维修所使用的器件
    private Long workload;			//工作量
}