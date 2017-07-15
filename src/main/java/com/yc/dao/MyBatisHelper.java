package com.yc.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisHelper {
	private static SqlSessionFactory sqlsessionFactory;
	  static{ 	
	    	try {
				String resource="mybatisConfiguration.xml";
				InputStream inputStream=Resources.getResourceAsStream(resource);
				sqlsessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	//构造sqlsession的工厂:   sql->相对于jdbc中的connection
	    }
	  public static SqlSession getSession(){
		 SqlSession session =sqlsessionFactory.openSession();
		 return session;
	  }
}
