package com.briup.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.ex.IndexResource;
import com.briup.demo.service.ICategoryExService;
import com.briup.demo.service.IIndexResourceService;
import com.briup.demo.service.ILinkService;
import com.briup.demo.utils.CustomerException;

/**
 * 查询首页所有数据的实现类
 * @author Administrator
 *
 */
@Service
public class IndexResourceServiceImpl implements IIndexResourceService {
	
	@Autowired
	private ILinkService linkService;
	
	@Autowired
	private ICategoryExService categoryExService;
	
	@Override
	public IndexResource findIndexAllResource() throws CustomerException {
		IndexResource resource = new IndexResource();
		//设置所有超链接信息
		resource.setLinks(linkService.findAllLinks());
		//设置所以栏目及其包含的文章信息
		resource.setCategoryExs(categoryExService.findAllCategoryEx());
		return resource;
	}

}
