package com.yx.emm504.Model.product;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class ProductInfo implements Serializable {
    private String productId;

    private String clientId;

    private String productType;

    private String machineRank;

    private String machineModel;

    private String serialNum;

    private String shortagePart;

    private String hdd;

    private String memory;

    private String pcCard;

    private String acAdapter;

    private String cell;

    private String cdRom;

    private String fd;

    private String startPassword;

    private String importData;

    private String other;

    private String machineFault;

    private String faultType;

    private String outerCheck;

    private Integer bookPrice;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date rcvDate;

    private String loginStatus;

    private static final long serialVersionUID = 1L;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getMachineRank() {
        return machineRank;
    }

    public void setMachineRank(String machineRank) {
        this.machineRank = machineRank;
    }

    public String getMachineModel() {
        return machineModel;
    }

    public void setMachineModel(String machineModel) {
        this.machineModel = machineModel;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getShortagePart() {
        return shortagePart;
    }

    public void setShortagePart(String shortagePart) {
        this.shortagePart = shortagePart;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getPcCard() {
        return pcCard;
    }

    public void setPcCard(String pcCard) {
        this.pcCard = pcCard;
    }

    public String getAcAdapter() {
        return acAdapter;
    }

    public void setAcAdapter(String acAdapter) {
        this.acAdapter = acAdapter;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getCdRom() {
        return cdRom;
    }

    public void setCdRom(String cdRom) {
        this.cdRom = cdRom;
    }

    public String getFd() {
        return fd;
    }

    public void setFd(String fd) {
        this.fd = fd;
    }

    public String getStartPassword() {
        return startPassword;
    }

    public void setStartPassword(String startPassword) {
        this.startPassword = startPassword;
    }

    public String getImportData() {
        return importData;
    }

    public void setImportData(String importData) {
        this.importData = importData;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getMachineFault() {
        return machineFault;
    }

    public void setMachineFault(String machineFault) {
        this.machineFault = machineFault;
    }

    public String getFaultType() {
        return faultType;
    }

    public void setFaultType(String faultType) {
        this.faultType = faultType;
    }

    public String getOuterCheck() {
        return outerCheck;
    }

    public void setOuterCheck(String outerCheck) {
        this.outerCheck = outerCheck;
    }

    public Integer getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Integer bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Date getRcvDate() {
        return rcvDate;
    }

    public void setRcvDate(Date rcvDate) {
        this.rcvDate = rcvDate;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", clientId=").append(clientId);
        sb.append(", productType=").append(productType);
        sb.append(", machineRank=").append(machineRank);
        sb.append(", machineModel=").append(machineModel);
        sb.append(", serialNum=").append(serialNum);
        sb.append(", shortagePart=").append(shortagePart);
        sb.append(", hdd=").append(hdd);
        sb.append(", memory=").append(memory);
        sb.append(", pcCard=").append(pcCard);
        sb.append(", acAdapter=").append(acAdapter);
        sb.append(", cell=").append(cell);
        sb.append(", cdRom=").append(cdRom);
        sb.append(", fd=").append(fd);
        sb.append(", startPassword=").append(startPassword);
        sb.append(", importData=").append(importData);
        sb.append(", other=").append(other);
        sb.append(", machineFault=").append(machineFault);
        sb.append(", faultType=").append(faultType);
        sb.append(", outerCheck=").append(outerCheck);
        sb.append(", bookPrice=").append(bookPrice);
        sb.append(", rcvDate=").append(rcvDate);
        sb.append(", loginStatus=").append(loginStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}