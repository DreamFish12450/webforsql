package com.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FindTeacherDao;

import com.beans.Teacher;
import com.beans.Users;
@WebServlet("/PreUpdateTeacher")
public class PreUpdateTeacher extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String Tno=request.getParameter("Tno");
        Users u=(Users)request.getSession().getAttribute("user");
        Teacher s=new FindTeacherDao().findTeacherByTno(Tno	, u);
        request.setAttribute("s", s);
        request.getRequestDispatcher("UpdateTeacher.jsp").forward(request, response);
    }
}
