package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Link;
import com.briup.demo.service.ILinkService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 与链接相关的和前端交互的web层
 * @author Administrator
 *
 */
@RestController
@Api(description = "链接相关接口")
public class LinkController {
	
	@Autowired
	private ILinkService linkService;
	
	@PostMapping("/addLink")
	@ApiOperation("新增链接")
	public Message<String> addLink(Link link) {
		try {
			linkService.saveOrupdateLink(link);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误：" + e.getMessage());
		}
	}
	
	@PostMapping("/updateLink")
	@ApiOperation("修改链接")
	public Message<String> updateLink(Link link) {
		linkService.saveOrupdateLink(link);
		return MessageUtil.success();
	}
	
	@GetMapping("/selectLinks")
	@ApiOperation("查询所有链接")
	public Message<List<Link>> selectLinks(){
		return MessageUtil.success(linkService.findAllLinks());
	}
	
	@GetMapping("/deleteLinkById")
	@ApiOperation("根据id删除链接")
	public Message<List<Link>> deleteById(int id){
		linkService.deleteLinkById(id);
		return MessageUtil.success();
	}
	
	@GetMapping("/selectLinksByNamelike")
	@ApiOperation("根据链接名查询")
	public Message<List<Link>> selectLinksByNamelike(String name){
		return MessageUtil.success(linkService.findLinksByNamelike(name));
	}

}
