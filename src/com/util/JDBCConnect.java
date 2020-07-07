package com.util;
import java.sql.*;


public class JDBCConnect {




    public  Connection getConnection() throws SQLException{
        return getConnection("zjut_info","admin1","123456");
    }
    public  Connection getConnection(String dbName,String username,String password) throws  SQLException{
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL数据库引擎
        String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName="+dbName;//数据源  ！！！！注意若出现加载或者连接数据库失败一般是这里出现问题
        String Name=username;
        String Pwd=password;
        try
        {
            Class.forName(driverName);
            Connection conn=DriverManager.getConnection(dbURL,Name,Pwd);
            System.out.println("success");
            return conn;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error");
            return null;
        }

    }
    public void destoryConnection(){

    }

}
