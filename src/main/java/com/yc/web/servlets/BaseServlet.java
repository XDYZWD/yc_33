package com.yc.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public abstract class BaseServlet extends HttpServlet {
	protected String charset="utf-8";
	protected String op;

	@Override
	public void init(ServletConfig config) throws ServletException {
		if(   config.getInitParameter("charset")!=null){
			charset=config.getInitParameter("charset");
		}
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(charset);
		resp.setCharacterEncoding(charset);
		op = req.getParameter("op");
		super.service(req, resp);
	}

	@Override // doGet方法处理GET请求方式
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	
	//只能用json解析非泛型数据
	protected void outJson(Object obj, HttpServletResponse resp) throws IOException{
		Gson gson=new Gson();
		String jsonstr=gson.toJson(obj);
		outJsonStr(jsonstr,resp);
	}

	public void outJsonStr(String jsonStr, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println(jsonStr);
		out.flush();
		out.close();
	}
}
