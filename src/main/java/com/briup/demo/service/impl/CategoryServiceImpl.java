package com.briup.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.ArticleExample;
import com.briup.demo.bean.Category;
import com.briup.demo.bean.CategoryExample;
import com.briup.demo.mapper.ArticleMapper;
import com.briup.demo.mapper.CategoryMapper;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.StatusCodeUtil;

/**
 * 栏目相关逻辑操作及处理
 * @author Administrator
 *
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Autowired
	private ArticleMapper articleMapper;
	
	@Override
	public void saveOrupdateCategory(Category category) throws CustomerException {
		//参数为引用类型，插入时要做判空处理
		//当栏目名称为空时
		if(category.getName() == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "栏目名称为空！");//等于null不会执行下面的语句
		}
		//当链接地址为空时
		if(category.getCode() == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "栏目编号为空！");
		}
		
		//栏目存在的话，抛出错误信息，不执行增加操作
		CategoryExample example = new CategoryExample();
		example.createCriteria().andNameEqualTo(category.getName());
		if(categoryMapper.selectByExample(example).size() != 0) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "栏目名称已存在！");
		}
		example.clear();
		example.createCriteria().andCodeEqualTo(category.getCode());
		if(categoryMapper.selectByExample(example).size() != 0) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "栏目编号已存在！");
		}
		
		//判断Category对象的id是否为空
		if(category.getId() == null) {//如果为空则新增栏目
			categoryMapper.insert(category);
		}else {//如果不为空则修改栏目
			categoryMapper.updateByPrimaryKey(category);
		}
	}

	@Override
	public List<Category> findAllCategorys() throws CustomerException {
		List<Category> list = categoryMapper.selectByExample(new CategoryExample());
		return list;
	}

	@Override
	public void deleteCategoryById(Integer id) throws CustomerException {
		//删除栏目的同时，需要先删除栏目中包含的文章信息
		ArticleExample example = new ArticleExample();
		example.createCriteria().andCategoryIdEqualTo(id);
		articleMapper.deleteByExample(example);
		categoryMapper.deleteByPrimaryKey(id);
	}

}
