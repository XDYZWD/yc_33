package com.yc.web.servlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.Favorite;
import com.yc.bean.Tag;
import com.yc.biz.FavoriteBiz;
import com.yc.biz.Impl.FavoriteBizImpl;
import com.yc.web.model.JsonModel;
@WebServlet("/favorite.action")
public class FavoriteAction extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7894226353670186739L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			if(op.equals("findAllTag")){
				findAllTag(req,resp);
			}else if(op.equals("findFavorite")){
				findFavorite(req,resp);
			}else if(op.equals("addFavorite")){
				addFavorite(req,resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void addFavorite(HttpServletRequest req, HttpServletResponse resp) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		// TODO Auto-generated method stub
		Favorite f=RequestUtil.getParemeter(req, Favorite.class);
		FavoriteBiz fb=new FavoriteBizImpl();
		fb.addFavrite(f);
		//清空application中的tag
		FavoriteBiz tb=new FavoriteBizImpl();
		List<Tag> list=tb.findAllTag();
		req.getServletContext().setAttribute("alltags", list);
		JsonModel jm=new JsonModel();
		jm.setCode(1);
		super.outJson(jm, resp);
	}

	private void findAllTag(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		List<Tag> list= (List<Tag>) req.getServletContext().getAttribute("alltags");
		JsonModel jm=new JsonModel();
		jm.setCode(1);
		jm.setObj(list);
		super.outJson(jm, resp);
	}

	private void findFavorite(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		String tname=req.getParameter("tname");
		FavoriteBiz fb=new FavoriteBizImpl();
		List<Favorite> list= fb.findFavorite(tname);
		JsonModel jm=new JsonModel();
		jm.setCode(1);
		jm.setObj(list);
		super.outJson(jm, resp);
	}

	
}
