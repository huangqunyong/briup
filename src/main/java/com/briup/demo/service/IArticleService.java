package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Article;
import com.briup.demo.utils.CustomerException;

/**
 * 文章相关内容的Service接口
 * @author Administrator
 *
 */
public interface IArticleService {
	
	/**
	 * 新增或修改文章
	 * @param article
	 * @throws CustomerException
	 */
	void saveOrupdateArticle(Article article) throws CustomerException;
	
	/**
	 * 根据id来修改文章
	 * @param id
	 * @throws CustomerException
	 */
	void deleteArticleById(Integer id) throws CustomerException;
	
	/**
	 * 根据条件查询文章
	 * @param name
	 * @param condition
	 * @return 文章类集合
	 * @throws CustomerException
	 */
	List<Article> findArticlesByCondition(String categoryName,String condition) throws CustomerException;
	
	/**
	 * 根据id查找文章
	 * @param id
	 * @return 文章类
	 * @throws CustomerException
	 */
	Article findArticleById(Integer id) throws CustomerException;
	
	/**
	 * 根据栏目id级联查询所有文章内容
	 * @param id
	 * @return 文章类List集合
	 * @throws CustomerException
	 */
	List<Article> findAllArticlesCategoryId(Integer id) throws CustomerException;
	
	//List<Article> findAllArticles() throws CustomerException;
	
}
