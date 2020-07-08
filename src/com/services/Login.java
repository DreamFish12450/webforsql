package com.services;

import com.beans.Users;
import com.dao.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName=request.getParameter("userName");
		String pwd=request.getParameter("pwd");
		Users u=new Users();
		u.setUserName(userName);
		u.setPws(pwd);
		LoginDao ld=new LoginDao();
		try {
			System.out.println("its"+userName);
			System.out.println(pwd);
			u.setUserName("sa");
			u.setPws("123456");
			ld.login(u);
			HttpSession session=request.getSession();
			session.setAttribute("user", u);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		} catch (Exception e) {e.printStackTrace();
			request.setAttribute("msg","登录失败！");
			request.getRequestDispatcher("showMessage.jsp").forward(request, response);
		}
	}
}