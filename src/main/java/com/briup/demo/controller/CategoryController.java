package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Category;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 与栏目相关的和前端交互的web层
 * @author Administrator
 *
 */
@RestController
@Api(description = "栏目相关接口")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;
	
	@PostMapping("/addCategory")
	@ApiOperation("新增栏目")
	public Message<String> addCategory(Category category){
		//为什么要try/catch,因为saveOrupdateCategory方法有向上抛自定义异常的可能
		try {
			categoryService.saveOrupdateCategory(category);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误：" + e.getMessage());
		}
	}
	
	@PostMapping("/updateCategory")
	@ApiOperation("修改栏目")
	public Message<String> updateCategory(Category category){
		try {
			categoryService.saveOrupdateCategory(category);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误：" + e.getMessage());
		}
	}
	
	@GetMapping("/selectAllCategorys")
	@ApiOperation("查询所有栏目数据")
	public Message<List<Category>> selectAllCategorys(){
		return MessageUtil.success(categoryService.findAllCategorys());
	}
	
	@GetMapping("/deleteById")
	@ApiOperation("根据id删除栏目数据")
	public Message<String> selectById(int id){
		categoryService.deleteCategoryById(id);
		return MessageUtil.success();
	}
	
}
