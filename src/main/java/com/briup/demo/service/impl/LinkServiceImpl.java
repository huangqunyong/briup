package com.briup.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Link;
import com.briup.demo.bean.LinkExample;
import com.briup.demo.mapper.LinkMapper;
import com.briup.demo.service.ILinkService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.StatusCodeUtil;

/**
 * 操作链接
 * @author Administrator
 *
 */
@Service
public class LinkServiceImpl implements ILinkService {

	@Autowired
	private LinkMapper linkMapper;
	
	@Override
	public void saveOrupdateLink(Link link) throws CustomerException {
		//参数为引用类型，要做判空处理
		//当链接名为空时
		if(link.getName() == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "链接名称为空！");//等于null不会执行下面的语句
		}
		//当链接名为空时
		if(link.getUrl() == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "链接地址为空！");
		}
		
		//判断Link对象的id是否为空，如果为空则新增链接，如果不为空则修改链接
		if(link.getId() == null) {
			linkMapper.insert(link);
		}else {
			linkMapper.updateByPrimaryKey(link);
		}
	}

	@Override
	public List<Link> findAllLinks() throws CustomerException {
//		LinkExample example = new LinkExample();
//		List<Link> list = linkMapper.selectByExample(example);
//		return list;
		return linkMapper.selectByExample(new LinkExample());
	}

	@Override
	public List<Link> findLinksByNamelike(String name) throws CustomerException {
		name = name == null ? "" : name.trim();
		LinkExample example = new LinkExample();
		
		if("".equals(name)) {
			//如果搜索条件没写，则返回所有数据
			return linkMapper.selectByExample(example);
		}else {
			//如果搜索条件写了，则模糊查询数据
			example.createCriteria().andNameLike("%" + name + "%");
			List<Link> list = linkMapper.selectByExample(example);
			return list;
		}
	}

	@Override
	public void deleteLinkById(int id) throws CustomerException {
		linkMapper.deleteByPrimaryKey(id);
	}

}
