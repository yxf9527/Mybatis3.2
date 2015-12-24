package com.mybatis.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtil {
	
	//mybatis资源文件
	private static final String resource = "sqlMapConfig.xml";
	
	private static SqlSession session = null;
	
	/**
	 * @throws  
	 * */
	public static SqlSession getSqlSession(){
		
		try {
			//资源文件转化为流
			InputStream in = Resources.getResourceAsStream(resource);
			//构建sqlsessionFactory工厂
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
			
			session = factory.openSession();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return session;
	}
	
	/**
	 * 关闭资源
	 * */
	public static void close(){
		if(session!=null){
			session.close();
		}
	}

}
