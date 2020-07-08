package com.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FindClassDao;

import com.beans.Class;
import com.beans.Users;
@WebServlet("/PreUpdateClass")
public class PreUpdateClass extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String classNumber=request.getParameter("classNumber");
        System.out.println("classNumber="+classNumber);
        Users u=(Users)request.getSession().getAttribute("user");
        Class s=new FindClassDao().findClassByclassNumber(classNumber, u);
        request.setAttribute("s", s);
        request.getRequestDispatcher("UpdateClass.jsp").forward(request, response);
    }
}
