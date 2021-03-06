package com.briup.demo.bean.ex;

import java.io.Serializable;
import java.util.List;

import com.briup.demo.bean.Link;

/**
 * 保存首页的所有数据
 * @author Administrator
 *
 */
public class IndexResource implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<CategoryEx> categoryExs;
	
	private List<Link> links;

	public IndexResource() {
		super();
	}

	public IndexResource(List<CategoryEx> categoryExs, List<Link> links) {
		super();
		this.categoryExs = categoryExs;
		this.links = links;
	}

	public List<CategoryEx> getCategoryExs() {
		return categoryExs;
	}

	public void setCategoryExs(List<CategoryEx> categoryExs) {
		this.categoryExs = categoryExs;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

}
