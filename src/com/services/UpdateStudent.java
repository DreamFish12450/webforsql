package com.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OperatorStudent;

import com.beans.Student;
import com.beans.Users;
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Student s=new Student();
        s.setSno(new String(request.getParameter("Sno").getBytes("iso-8859-1"), "utf-8"));
        s.setSname(new String(request.getParameter("Sname").getBytes("iso-8859-1"), "utf-8"));
        s.setSsex(new String(request.getParameter("Ssex").getBytes("iso-8859-1"), "utf-8"));
        String Sage=new String(request.getParameter("Sage").getBytes("iso-8859-1"), "utf-8");
        if(Sage!=null&&Sage.length()>0){
            s.setSage(Integer.parseInt(Sage));
        }else
            s.setSage(0);
        s.setSourceOfStudents(new String(request.getParameter("sourceOfStudents").getBytes("iso-8859-1"), "utf-8"));
        s.setClassNumber(new String(request.getParameter("classNumber").getBytes("iso-8859-1"), "utf-8"));
        OperatorStudent os=new OperatorStudent();
        Users u=(Users)request.getSession().getAttribute("user");
        os.updateStudent(s, u);
        request.setAttribute("msg", "修改成功！");
        request.getRequestDispatcher("showMessage.jsp").forward(request, response);
    }
}
