package com.yx.emm504.Model.product;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductToClient implements Serializable {
    private String unit_name;

    private String connect_people;

    private String productType;

    private String machineRank;

    private String machineModel;

    private String serialNum;

    private String shortagePart;

    private String machineFault;
}
