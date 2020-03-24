package com.briup.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.ex.IndexResource;
import com.briup.demo.service.impl.IndexResourceServiceImpl;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 与首页相关的和前端交互的web层
 * @author Administrator
 *
 */
@RestController
@Api(description = "首页需要的所有数据")
public class IndexResourceController {
	
	@Autowired
	private IndexResourceServiceImpl IndexResourceService;
	
	@GetMapping("/getIndexResource")
	@ApiOperation("首页展示的所有数据")
	public Message<IndexResource> getIndexResource(){
		return MessageUtil.success(IndexResourceService.findIndexAllResource());
	}
	
}
