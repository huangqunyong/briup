package com.briup.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Article;
import com.briup.demo.bean.ArticleExample;
import com.briup.demo.bean.Category;
import com.briup.demo.bean.CategoryExample;
import com.briup.demo.mapper.ArticleMapper;
import com.briup.demo.mapper.CategoryMapper;
import com.briup.demo.service.IArticleService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.StatusCodeUtil;

/**
 * 文章相关逻辑操作及处理
 * @author Administrator
 *
 */
@Service
public class ArticleServiceImpl implements IArticleService {
	
	@Autowired
	private ArticleMapper articleMapper;
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public void saveOrupdateArticle(Article article) throws CustomerException {
		if(article == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数为空");
		}
		if(article.getId() == null) {
			//需要额外添加两条数据，前台只传过来三个数据author（作者），title（文章名），content（文章内容）
			article.setPublishdate(new Date());
			article.setClicktimes(0);
			articleMapper.insert(article);
		}else {
			//更改文章数据只能更改更新日期，不能增加点击数量
			article.setPublishdate(new Date());
			articleMapper.updateByPrimaryKey(article);
		}
	}

	@Override
	public void deleteArticleById(Integer id) throws CustomerException {
		articleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Article> findArticlesByCondition(String categoryName, String condition) throws CustomerException {
		//分四种情况
		categoryName = categoryName == null ? "" : categoryName.trim();
		condition = condition == null ? "" : condition.trim();
		
		ArticleExample articleExample = new ArticleExample();
		CategoryExample categoryExample = new CategoryExample();
		//1.没有添加任何条件，则查询所有文章
		if("".equals(categoryName) && "".equals(condition)) {
			return articleMapper.selectByExample(articleExample);
		}
		//2.没有指定栏目，但指定了查询的关键字，则根据关键字查询满足条件的所有文章
		else if(!"".equals(condition) && "".equals(categoryName)) {
			articleExample.createCriteria()
						  .andTitleLike("%" + condition + "%");
			return articleMapper.selectByExample(articleExample);
		}
		//3.指定栏目，没有指定查询的关键字，则根据栏目查询其中所有文章
		else if(!"".equals(categoryName) && "".equals(condition)) {
			articleExample.clear();
			//找出栏目信息
			categoryExample.createCriteria()
						   .andNameEqualTo(categoryName);
			List<Category> category = categoryMapper.selectByExample(categoryExample);
			
			if(category.size() > 0) {
				//根据栏目信息，找出里面所有文章
				articleExample.createCriteria()
				.andCategoryIdEqualTo(category.get(0).getId());
				return articleMapper.selectByExample(articleExample);
			}else {
				throw new CustomerException(StatusCodeUtil.ERROR_CODE, "没有此栏目名称");
			}
		}
		//4.指定栏目，同时指定查询的关键字，则根据栏目和关键字查询满足条件的文章
		else {
			articleExample.clear();
			categoryExample.clear();
			//找出栏目信息
			categoryExample.createCriteria()
						   .andNameEqualTo(categoryName);
			List<Category> category = categoryMapper.selectByExample(categoryExample);
			
			//根据栏目信息，找出里面所有文章
			articleExample.createCriteria()
						  .andTitleLike("" + condition + "")
						  .andCategoryIdEqualTo(category.get(0).getId());
			return articleMapper.selectByExample(articleExample);
		}
	}

	@Override
	public Article findArticleById(Integer id) throws CustomerException {
		if(id == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数为空");
		}
		return articleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Article> findAllArticlesCategoryId(Integer id) throws CustomerException {
		ArticleExample example = new ArticleExample();
		example.createCriteria().andCategoryIdEqualTo(id);
		return articleMapper.selectByExample(example);
	}

}
