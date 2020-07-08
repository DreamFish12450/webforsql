package com.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FindStudentDao;
import com.beans.Student;
import com.beans.Users;
@WebServlet("/FindStudent")
public class FindStudent extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Student s=new Student();   /*获取存在request中员工的基本信息，并建立员工对象*/
        s.setSno(new String(request.getParameter("Sno").getBytes("iso-8859-1"), "utf-8"));
        Users u=(Users)request.getSession().getAttribute("user");  /*获取当前会话中的User使用者，判断其是否有查询的权限*/
        List<Student> list=null;
        if(s.getSno()!=null&&s.getSno().length()>0){   /*通过编号来查询教师信息*/
            System.out.println("111");
            Student ss=new FindStudentDao().findStudentBySno(s.getSno(), u);
            if(ss==null){
                request.setAttribute("msg", "未找到结果！");
                request.getRequestDispatcher("showMessage.jsp").forward(request, response);
            }else{
                list=new ArrayList<Student>();
                list.add(ss);
                request.setAttribute("list", list);
                request.getRequestDispatcher("showStudent.jsp").forward(request, response);
            }
        }
        else{}
    }

}
