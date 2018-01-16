package com.nyh.app.core.service.test;

import com.github.pagehelper.PageInfo;
import com.nyh.app.common.vo.PageVo;
import com.nyh.app.common.vo.test.TestVo;
import com.nyh.app.core.orm.test.domain.Test;

public interface TestService {

	String insert(TestVo testVo);

	Test findUserByName(String name);

	PageInfo<Test> findAll(PageVo pageVo);

}
