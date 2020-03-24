package com.briup.demo.mapper.ex;

import java.util.List;

import com.briup.demo.bean.ex.CategoryEx;

/**
 * 处理、查询栏目及其包含内容
 * @author Administrator
 *
 */
public interface CategoryExMapper {
	
	/**
	 * 查找所有栏目信息以及级联的文章信息
	 * @return 栏目拓展类List集合
	 */
	List<CategoryEx> findAllCategoryExs();
	
}
