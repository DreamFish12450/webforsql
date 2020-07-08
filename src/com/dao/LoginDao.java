package com.dao;

import com.beans.Users;
import com.common.JdbcUtil;

import java.sql.Connection;

public class LoginDao {  /*判断当前用户是否可以登录数据库*/
	public void login(Users u) throws Exception{
		Connection conn= JdbcUtil.getConnection(u.getUserName(), u.getPwd());
	}
}
