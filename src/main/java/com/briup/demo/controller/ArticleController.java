package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Article;
import com.briup.demo.service.IArticleService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 与文章相关的和前端交互的web层
 * @author Administrator
 *
 */
@RestController
@Api(description = "文章相关接口")
public class ArticleController {
	
	@Autowired
	private IArticleService articleService;
	
	@PostMapping("/addArticle")
	@ApiOperation("添加文章")
	public Message<String> saveArticle(Article article){
		try {
			articleService.saveOrupdateArticle(article);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误：" + e.getMessage());
		}
	}
	
	@PostMapping("/updateArticle")
	@ApiOperation("修改文章")
	public Message<String> updateArticle(Article article){
		articleService.saveOrupdateArticle(article);
		return MessageUtil.success();
	}
	
	@GetMapping("/deleteArticleById")
	@ApiOperation("根据id删除文章")
	public Message<String> deleteArticleById(Integer id){
		articleService.deleteArticleById(id);
		return MessageUtil.success();
	}
	
	@GetMapping("/selectArticleByCondition")
	@ApiOperation("根据条件查询文章")
	public Message<List<Article>> selectArticleByCondition(String categoryName, String condition){
		try {
			return MessageUtil.success(articleService.findArticlesByCondition(categoryName, condition));
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误：" + e.getMessage());
		}
	}
	
	@GetMapping("/selectArticleById")
	@ApiOperation("根据id查找文章")
	public Message<Article> selectArticleById(Integer id){
		try {
			//先查找出文章
			Article article = articleService.findArticleById(id);
			//浏览次数+1
			article.setClicktimes(article.getClicktimes() + 1);
			//修改文章
			articleService.saveOrupdateArticle(article);
			return MessageUtil.success(articleService.findArticleById(id));
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误：" + e.getMessage());
		}
	}
	
	@GetMapping("/selectAllArticlesCategoryId")
	@ApiOperation("根据栏目id查找所有文章")
	public Message<List<Article>> selectAllArticlesCategoryId(Integer id){
		return MessageUtil.success(articleService.findAllArticlesCategoryId(id));
	}
	
}
