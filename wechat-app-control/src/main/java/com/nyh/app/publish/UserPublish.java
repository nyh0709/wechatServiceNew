package com.nyh.app.publish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nyh.app.common.vo.publish.PublishVo;
import com.nyh.app.core.service.publish.UserPublishService;
import com.nyh.app.provider.anotation.IgnoreUserId;
import com.nyh.app.provider.controller.AbstractController;


@RestController
@RequestMapping("/publish")
public class UserPublish extends AbstractController{
	
	@Autowired
	private UserPublishService userpublishservice;
	

	@PostMapping("/upload")
	public ResponseEntity<Object> upload(MultipartFile file){
		return wrapperFunction((p)->userpublishservice.saveimage(p),file);
	}
	@PostMapping("/content")
	public ResponseEntity<Object>  publishcontent(@RequestBody PublishVo pubvo){
		return wrapperFunction((p)->userpublishservice.savecontent(p), pubvo);
		
	}

}
