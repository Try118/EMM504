package com.yx.emm504.Model;

import java.util.Date;

import lombok.Data;

@Data
public class OutPartsModel {
	private String parts_name;//部件名称012345
	private String parts_model;//型号
	private String product_id;//维修编号
	private int count;//数量
	private double unit_price;//单价
	private Date out_date;//出库日期

}
