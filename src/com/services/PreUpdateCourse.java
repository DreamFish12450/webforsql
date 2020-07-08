package com.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FindCourseDao;

import com.beans.Course;
import com.beans.Users;
@WebServlet("/PreUpdateCourse")
public class PreUpdateCourse extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String Cno=request.getParameter("Cno");
        String openSemester=request.getParameter("openSemester");
        System.out.println("CNO="+Cno+" "+"openSemester="+openSemester);
        Users u=(Users)request.getSession().getAttribute("user");
        Course s=new FindCourseDao().findCourseByCnoopenSemester(Cno,openSemester, u);
        request.setAttribute("s", s);
        request.getRequestDispatcher("UpdateCourse.jsp").forward(request, response);
    }
}
