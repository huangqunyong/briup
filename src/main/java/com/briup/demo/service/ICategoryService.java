package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Category;
import com.briup.demo.utils.CustomerException;

/**
 * 栏目相关的Service层
 * @author Administrator
 *
 */
public interface ICategoryService {
	
	/**
	 * 保存或修改链接信息
	 * @param 栏目对象
	 * @throws CustomerException
	 */
	void saveOrupdateCategory(Category category) throws CustomerException;
	
	/**
	 * 查询所有栏目信息
	 * @return 栏目对象的List集合
	 * @throws CustomerException
	 */
	List<Category> findAllCategorys() throws CustomerException;
	
	/**
	 * 根据id删除栏目信息
	 * @param id
	 * @throws CustomerException
	 */
	void deleteCategoryById(Integer id) throws CustomerException;
	
}
