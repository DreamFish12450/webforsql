package com.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@WebServlet("/test1")
public class test1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=test";

        try {
            //1.加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("加载驱动成功！");
            //2.连接
            Connection dbConn = DriverManager.getConnection(dbURL, "sa", "123456");
            System.out.println("success！");
            String sql="select * from people";
            PreparedStatement statement=null;
            statement=dbConn.prepareStatement(sql);
            ResultSet res=null;
            res=statement.executeQuery();
            while(res.next()){
                String title=res.getString("name1");
                System.out.println(title);
            }
            dbConn.close();
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("连接数据库失败！");
        }


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
