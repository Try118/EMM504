package com.yx.emm504.Model.maintain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getMaintainStatus() {
        return maintainStatus;
    }

    public void setMaintainStatus(String maintainStatus) {
        this.maintainStatus = maintainStatus == null ? null : maintainStatus.trim();
    }

    public String getMaintainNote() {
        return maintainNote;
    }

    public void setMaintainNote(String maintainNote) {
        this.maintainNote = maintainNote == null ? null : maintainNote.trim();
    }

    public String getCheckNote() {
        return checkNote;
    }

    public void setCheckNote(String checkNote) {
        this.checkNote = checkNote == null ? null : checkNote.trim();
    }

    public String getMaintainMan() {
        return maintainMan;
    }

    public void setMaintainMan(String maintainMan) {
        this.maintainMan = maintainMan == null ? null : maintainMan.trim();
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public String getUsedParts() {
        return usedParts;
    }

    public void setUsedParts(String usedParts) {
        this.usedParts = usedParts == null ? null : usedParts.trim();
    }

    public Long getWorkload() {
        return workload;
    }

    public void setWorkload(Long workload) {
        this.workload = workload;
    }
}