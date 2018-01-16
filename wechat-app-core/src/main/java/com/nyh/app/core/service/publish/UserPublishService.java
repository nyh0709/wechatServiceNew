package com.nyh.app.core.service.publish;

import org.springframework.web.multipart.MultipartFile;

import com.nyh.app.common.vo.publish.PublishVo;

public interface UserPublishService {
	
	//保存图片
	 PublishVo saveimage(MultipartFile file);
	//保存发表内容
	 PublishVo savecontent(PublishVo pub);
	

}
