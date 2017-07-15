package com.yc.biz.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yc.bean.Favorite;
import com.yc.bean.Tag;
import com.yc.biz.FavoriteBiz;
import com.yc.dao.FavoriteDao;
import com.yc.dao.TagDao;
import com.yc.dao.impl.FavoriteDaoImpl;
import com.yc.dao.impl.TagDaoImpl;

public class FavoriteBizImpl implements FavoriteBiz {
	private FavoriteDao fd=new FavoriteDaoImpl();
	private TagDao td=new TagDaoImpl();
	@Override
	public void addFavrite(Favorite fav) {
		// TODO Auto-generated method stub
		fd.addFavorite(fav);
		String ftags=fav.getFtags();
		if(ftags!=null&&!ftags.equals("")){
			//1.,分割
			String[] tags=ftags.split(",");
			for(String t:tags){
				Tag tag=new Tag();
				tag.setTname(t);
				tag=td.selectTagByName(tag);  //查是否存在这个tag
				if(tag==null){
					//没有这个标签，则添加一个到tag表，并添加一个中间表
					tag=new Tag();
					tag.setTname(t);
					td.addTag(tag);
				}else{
					//原来有这个标签，则添加数量即可
					td.increassCount(tag);
				}
				//添加中间表
				Map<String,String> map=new HashMap<String,String>();
				map.put("tid", tag.getTid()+"");
				map.put("fid", fav.getFid()+"");
				td.addTagFavorite(map);
			}
		}
	}

	@Override
	public List<Tag> findAllTag() {
		// TODO Auto-generated method stub
		return td.selectTagAll();
	}

	@Override
	public List<Favorite> findFavorite(String condition) {
		// TODO Auto-generated method stub
		Favorite f=new Favorite();
		if(condition.equals("全部")){
			f.setFtags("");
		}else if(condition.equals("未分类")){
		}else{
			f.setFtags(condition);
		}
		return fd.selectFavoriteAll(f);
	}

}
