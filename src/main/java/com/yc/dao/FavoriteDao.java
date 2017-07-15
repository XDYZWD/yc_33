package com.yc.dao;

import java.util.List;

import com.yc.bean.Favorite;

public interface FavoriteDao {
		/**
		 * 查询连接  ：查询所有的/查询未分类的
		 * 未分类 ->  f_tags=null
			查询所有  f_tags="'  
		 */
		public List<Favorite> selectFavoriteAll(Favorite favorite);
		
		/**
		 * 添加连接
		 */
		public void addFavorite(Favorite favorite);
}
