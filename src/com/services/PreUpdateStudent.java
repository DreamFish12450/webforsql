package com.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FindStudentDao;

import com.beans.Student;
import com.beans.Users;
@WebServlet("/PreUpdateStudent")
public class PreUpdateStudent extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String Sno=request.getParameter("Sno");
        Users u=(Users)request.getSession().getAttribute("user");
        Student s=new FindStudentDao().findStudentBySno(Sno	, u);
        request.setAttribute("s", s);
        request.getRequestDispatcher("UpdateStudent.jsp").forward(request, response);
    }
}
