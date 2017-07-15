package com.yc.web.listeners;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.yc.bean.Tag;
import com.yc.biz.FavoriteBiz;
import com.yc.biz.Impl.FavoriteBizImpl;
//当容器启动时就加载所有的标签.....使用铃听器实现
public class InitListener implements ServletContextListener { //servletContext  ->application

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}
	//创建FavoriteBizImpl对象,调用findAllTag()方法获取所有的List<Tag> 存到application中
	//TODO:以后再添加Tag,将要同步修改  application中的list<tag>
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		FavoriteBiz tb=new FavoriteBizImpl();
		try {
			List<Tag> list=tb.findAllTag();
			arg0.getServletContext().setAttribute("alltags", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
