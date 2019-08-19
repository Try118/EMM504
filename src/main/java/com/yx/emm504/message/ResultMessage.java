package com.yx.emm504.message;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ResultMessage<T> implements Serializable {

	private String message = null;
	private String status = null;
	private T model = null;// 业务对象
	private List<T> list = null;// 业务对象列表

	private int rows = 0;// 每屏显示的行数
	private int page = 0;// 第几页
	private int count = 0;// T的个数
	private int pageCount = 0;// 页数

	public ResultMessage(String status, String message) {
		this.message = message;
		this.status = status;
	}

}
