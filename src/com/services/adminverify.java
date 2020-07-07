package com.services;

import com.util.JDBCConnect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminverify
 */
@WebServlet("/adminverify.do")
public class adminverify extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public adminverify() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name=request.getParameter("Username");
		String password=request.getParameter("Password");
		String iden = request.getParameter("identity");
		JDBCConnect jdbcConnect = new JDBCConnect();
		try {
			System.out.println(request.getParameter("Username"));
			Connection connection = jdbcConnect.getConnection();
			if(iden.equals("学生"))
			{
				String usrName = request.getParameter("Username");
				String pass = request.getParameter("Password");
				String sql = "select zky_Sno08 from zhouky_Students08 where zky_Sname08 = ?";
				PreparedStatement pstmt = connection.prepareStatement(sql);
				pstmt.setString(1,usrName);
				ResultSet rst = pstmt.executeQuery();
				String Sno = null;
				if(rst.next()){
					Sno = rst.getString("zky_Sno08");
				}
				jdbcConnect.destoryConnection();
				if(pass.equals(Sno)){
					System.out.println("password is"+pass);
					request.setAttribute("Sno",Sno);
					request.getRequestDispatcher("student.jsp").forward(request,response);
				}else {
					request.setAttribute("errorInfo","用户名密码错误请检查");
					request.getRequestDispatcher("index.jsp").forward(request,response);
				}

			}
			else {
				String usrName = request.getParameter("Username");
				String pass = request.getParameter("Password");
				String sql = "select zky_Tno08 from zhouky_Teacher08 where zky_Tname08 = ?";
				PreparedStatement pstmt = connection.prepareStatement(sql);
				pstmt.setString(1,usrName);
				ResultSet rst = pstmt.executeQuery();
				String Tno = null;
				if(rst.next()){
					Tno = rst.getString("zky_Tno08");
				}
				jdbcConnect.destoryConnection();
				if(pass.equals(Tno)){
					request.setAttribute("Tno",Tno);
					request.getRequestDispatcher("teacher.jsp").forward(request,response);
				}else {
					request.setAttribute("errorInfo","用户名密码错误请检查");
					request.getRequestDispatcher("index.jsp").forward(request,response);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
		doGet(request, response);
	}

}
