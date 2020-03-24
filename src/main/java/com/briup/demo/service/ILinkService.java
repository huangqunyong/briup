package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Link;
import com.briup.demo.utils.CustomerException;

/**
 * 关于链接的相关操作
 * @author Administrator
 *
 */
public interface ILinkService {
	
	/**
	 * 保存或修改链接信息
	 * @param link
	 */
	void saveOrupdateLink(Link link) throws CustomerException;
	
	/**
	 * 查询所有链接信息
	 * 
	 */
	List<Link> findAllLinks() throws CustomerException;
	
	/**
	 * 根据链接名模糊查询链接信息
	 * 
	 */
	List<Link> findLinksByNamelike(String name) throws CustomerException;
	
	/**
	 * 根据id删除链接信息
	 * 
	 */
	void deleteLinkById(int id) throws CustomerException;
	
}
