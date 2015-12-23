package com.mybatis.crud;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.pojo.Student;

public class insertCrud {
	
	public static void main(String[] args) throws IOException {
		//mybatis配置文件
		String config = "sqlMapConfig.xml";
		
		//对mybatis流化
		InputStream in = Resources.getResourceAsStream(config);
		
		//创建会话工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		
		//创建会话
		SqlSession session = factory.openSession();
		
		//构建要创建的类
		Student student = new Student();
		student.setId("6");
		student.setUsername("杨云红");
		student.setSex("男");
		student.setAddress("安徽省");
		student.setBirthday(new Date());
		
		int results = session.insert("test.insertStudent", student);
		session.commit();
		
		System.out.println(results+"条数据插入成功！并生成主键："+student.getId());
		
		//释放资源
		session.close();
	}

}
