/**  
 * All rights Reserved, Designed By Suixingpay.
 * @author: houmin[hou_no1@163.com] 
 * @date: 2017-12-26 22:16:39  
 * @Copyright ©2017 Suixingpay. All rights reserved. 
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.nyh.app.core.service.index;

import com.github.pagehelper.PageInfo;
import com.nyh.app.common.vo.PageVo;
import com.nyh.app.core.orm.index.domain.Pubinfo;
import com.nyh.app.common.vo.index.PubinfoVo;

/**
 * TODO
 *
 * @author houmin[hou_no1@163.com]
 * @date: 2017-12-26 22:16:39
 * @review: houmin[hou_no1@163.com]/2017-12-26 22:16:39
 */
public interface PubinfoService {

	String insert(PubinfoVo vo);

	PageInfo<Pubinfo> findAll(PageVo pageVo);

}