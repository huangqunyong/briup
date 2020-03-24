package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.utils.CustomerException;

/**
 * 栏目拓展类Service层接口
 * @author Administrator
 *
 */
public interface ICategoryExService {
	
	/**
	 * 查找所有栏目信息以及级联的文章信息
	 * @return 栏目拓展类List集合
	 * @throws CustomerException
	 */
	List<CategoryEx> findAllCategoryEx() throws CustomerException;
	
}
