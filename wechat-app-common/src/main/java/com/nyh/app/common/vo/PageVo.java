package com.nyh.app.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PageVo {
	//第几页
	private int pageNum;
	//每页条数
	private int pageSize;

}
