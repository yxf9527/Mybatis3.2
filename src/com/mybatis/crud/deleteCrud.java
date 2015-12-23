package com.mybatis.crud;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class deleteCrud {
	
	public static void main(String[] args) throws IOException {
		//配置文件
		String config = "sqlMapConfig.xml";
		
		//将配置文件转换为流
		InputStream in = Resources.getResourceAsStream(config);
		
		//创建sqlsessionfactory工厂生成sqlsession会话
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		
		//创建sqlsession会话
		SqlSession session = factory.openSession();
		
		int results = session.delete("test.deleteStudentByName", "红");
		session.commit();
		
		System.out.println(results+"条数据被删除！");
		
		//释放资源
		session.close();
		
	}

}
