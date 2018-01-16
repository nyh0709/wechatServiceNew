package com.nyh.app.provider.controller.index;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.nyh.app.common.vo.PageVo;
import com.nyh.app.core.orm.index.domain.Pubinfo;
import com.nyh.app.core.service.index.PubinfoService;
import com.nyh.app.provider.anotation.IgnoreUserId;
import com.nyh.app.provider.controller.AbstractController;

@RestController
@RequestMapping("/index")
public class PubinfoController extends AbstractController {

	@Autowired
	private PubinfoService pubinfoService;
	
	@PostMapping("/findAll")
	@IgnoreUserId
	public ResponseEntity<PageInfo<Pubinfo>> findAll(@RequestBody PageVo pageVo) throws IOException {
		return wrapperFunction((p)->pubinfoService.findAll(p),pageVo);
	}
}
