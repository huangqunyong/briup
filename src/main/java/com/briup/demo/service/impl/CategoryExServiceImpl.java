package com.briup.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.mapper.ex.CategoryExMapper;
import com.briup.demo.service.ICategoryExService;

/**
 * 栏目拓展类Service层的实现类
 * @author Administrator
 *
 */
@Service
public class CategoryExServiceImpl implements ICategoryExService {

	@Autowired
	private CategoryExMapper categoryExMapper;
	
	@Override
	public List<CategoryEx> findAllCategoryEx() {
		return categoryExMapper.findAllCategoryExs();
	}

}
