package com.nyh.app.provider.demo;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
//@CrossOrigin
public class Demo {
	@GetMapping("/test/{name}")
	public String test(@PathVariable String name,HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "hello " + name;
	}
	
}
