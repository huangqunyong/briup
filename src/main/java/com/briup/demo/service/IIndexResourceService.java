package com.briup.demo.service;

import com.briup.demo.bean.ex.IndexResource;
import com.briup.demo.utils.CustomerException;

/**
 * 首页数据管理的Service层接口
 * @author Administrator
 *
 */
public interface IIndexResourceService {

	/**
	 * 查找首页所有资源
	 * @return 首页所有数据
	 * @throws CustomerException
	 */
	IndexResource findIndexAllResource() throws CustomerException;
	
}
