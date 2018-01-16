package com.nyh.app.provider.controller.test;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.nyh.app.common.vo.PageVo;
import com.nyh.app.common.vo.test.TestVo;
import com.nyh.app.core.orm.test.domain.Test;
import com.nyh.app.core.service.test.TestService;
import com.nyh.app.provider.anotation.IgnoreUserId;
import com.nyh.app.provider.controller.AbstractController;

@RestController
@RequestMapping("/test")
public class TestController extends AbstractController {
	@Autowired
	private TestService testService;
	
	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody TestVo testVo) throws IOException {
		return wrapperFunction((p)->testService.insert(p),testVo);
	}
	
	@GetMapping("/find/{name}")
	
	public ResponseEntity<Test> findUserByName(@PathVariable String name) throws IOException {
		return wrapperFunction((p)->testService.findUserByName(p),name);
	}
	
	@PostMapping("/findAll")
	public ResponseEntity<PageInfo<Test>> findAll(@RequestBody PageVo pageVo) throws IOException {
		return wrapperFunction((p)->testService.findAll(p),pageVo);
	}

}
