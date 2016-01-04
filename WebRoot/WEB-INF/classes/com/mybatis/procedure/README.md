mybatis中调用存储过程  可以根据存储过程的性质  进行调用相关的增删改查方法

例如  存储过程要完成根据id查询  那么  可以调用sqlsession.selectone()
	要完成删除的操作可以调用delete。。  
	