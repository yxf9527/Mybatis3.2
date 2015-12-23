package com.mybatis.crud;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class updateCrud {
	
	public static void main(String[] args) throws IOException {
		//配置文件
		String config = "sqlMapConfig.xml";
		
		//将sqlMapConfig.xml转化成流
		InputStream in = Resources.getResourceAsStream(config);
		
		//创建sqlsession工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		
		SqlSession session = factory.openSession();
		
		//构建参数map
		HashMap<String,Object> para = new HashMap<String, Object>();
		para.put("birthday", new Date());
		para.put("address","香港特别行政区");
		para.put("address_stu", "香港");
		
		int results = session.update("test.updateStudent",para);
		session.commit();
		
		System.out.println(results+"条数据被更改！"); 
		session.close();
		
	}

}
