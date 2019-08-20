package com.yx.emm504.Model.maintain;

import java.util.Date;

public class MaintainInfo {
    private String productId;//ggggssss

    private String maintainStatus;

    private String maintainNote;

    private String checkNote;

    private String maintainMan;

    private Date processDate;

    private String usedParts;

    private Long workload;

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