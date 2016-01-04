package com.mybatis.procedure;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.mybatis.pojo.Student;
import com.mybatis.utils.SqlSessionUtil;

public class ProcedureDemo {
	
	@Test
	public void queryTest(){
		SqlSession session = SqlSessionUtil.getSqlSession();
		//根据存储过程的性质  选择sqlsession的增删改查方法
		Student stu = (Student)session.selectOne("test.proce_1", "张学友");
		
		System.out.println(stu.getBirthday());
	}
	

}
