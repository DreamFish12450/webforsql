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
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Student s=new Student();
        System.out.println(request.getParameter("Sno1")+123);
        s.setSno(new String(request.getParameter("Sno1").getBytes("iso-8859-1"), "utf-8"));
        s.setSname(new String(request.getParameter("Sname1").getBytes("iso-8859-1"), "utf-8"));
        s.setSsex(new String(request.getParameter("Ssex1").getBytes("iso-8859-1"), "utf-8"));
        String Sage=new String(request.getParameter("Sage1").getBytes("iso-8859-1"), "utf-8");
        if(Sage!=null&&Sage.length()>0){
            s.setSage(Integer.parseInt(Sage));
        }else
            s.setSage(0);
        s.setSourceOfStudents(new String(request.getParameter("sourceOfStudents1").getBytes("iso-8859-1"), "utf-8"));
        s.setClassNumber(new String(request.getParameter("classNumber1").getBytes("iso-8859-1"), "utf-8"));
        OperatorStudent os=new OperatorStudent();
        Users u=(Users)request.getSession().getAttribute("user");
        os.addStudent(s, u);  /*判断当前用户是否有插入权限，若有则向数据库中插入数据*/
        request.setAttribute("msg", "添加成功！");
        request.getRequestDispatcher("showMessage.jsp").forward(request, response);
    }

}
