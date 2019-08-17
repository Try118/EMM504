package com.yx.emm504.Model;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ClientModel {
	private String client_id;//客户编号
	private String identify_id;//身份证编号
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date rec_time;//客户送机时间
	private String client_property;//客户属性0123
	private String unit_name;//单位名称
	private String phone_number;//座机
	private String mobile_number;//移动电话
	private String client_address;//客户地址
	private String zip_code;//邮编
	private String connect_people;//联系人
	private String email;//email
}
