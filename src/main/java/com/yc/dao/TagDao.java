package com.yc.dao;

import java.util.List;
import java.util.Map;

import com.yc.bean.Favorite;
import com.yc.bean.Tag;

public interface TagDao {
	/**
	 * 查询所有的标签
	 */
	public List<Tag> selectTagAll();
	/**
	 * 根据标签名查这个标签下所有的favorite
	 */
	public List<Favorite> selectFavoriteByTname(Tag tag);
	/**
	 * 根据标签名查询这个标签是否存在
	 */
	public Tag selectTagByName(Tag tag);
	
	public void addTag(Tag tag);
	
	public void increassCount(Tag tag);
	/**
	 * 中间关系表
	 */
	public void addTagFavorite(Map<String,String> map);
}
