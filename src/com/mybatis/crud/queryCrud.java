package com.mybatis.crud;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis.pojo.Student;

/**
 * 查询测试类
 * */
public class queryCrud {
	
	public static void main(String[] args) throws IOException {
		
		//mybatis的配置文件
		String resource = "sqlMapConfig.xml";
		
		InputStream in = Resources.getResourceAsStream(resource);
		
		//创建会话工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		
		//得到sqlsession
		SqlSession session = factory.openSession();
		
		Student student = session.selectOne("test.findStudentById","1");
		
		System.out.println(student);
		
		//释放资源
		session.close();
		
	}
	
	@Test
	public void queryStudentByName() throws IOException{
		//mybatis配置文件
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		
		//创建会话工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		
		SqlSession session = factory.openSession();
		
		List<Student> list = session.selectList("test.findStudentByName", "明");
		
		for (Student student : list) {
			System.out.println(student);
		}
		
		//释放资源
		session.close();
	}

}
