package com.yc.biz;

import java.util.List;

import com.yc.bean.Favorite;
import com.yc.bean.Tag;

public interface FavoriteBiz {
	/**
	 * ->:所有的这些操作要在一个事物中（要采用spring的事物处理机制）
	 * 从fav中取出ftags（门户，军事），根据，分割，取出每个标签。【“门户”，“军事”】
	 * 循环查是否有门户 ，是否有军事
	 * 存在则更新这个标签数量-》tagMapper中的increaseCount方法
	 * 不存在，则向tag中加入一条数据-. 。》tagmapper中的addtag  ->还要在自己表加入关系的数据
	 * 在想favorite 添加一条数据  favoritemapper的addfav
	 */
	public void addFavrite(Favorite fav);
	
	/**
	 * 查询所有的tag
	 * 用于云图，  首页显示所有的tag
	 * 解决方法： tagmapper selectTagALL
	 * 
	 */
	public List<Tag> findAllTag();
	
	/**
	 * condition:值有“全部”，“未分类”,标签值
	 */
	public List<Favorite> findFavorite(String condition);
	
	
	
	
	
}
