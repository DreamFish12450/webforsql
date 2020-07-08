package com.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FindClassDao;
import com.beans.Class;
import com.beans.Users;
import com.dao.FindTeacherDao;

@WebServlet("/FindClass")
public class FindClass extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Class s=new Class();   /*获取存在request中员工的基本信息，并建立员工对象*/
        s.setClassNumber(new String(request.getParameter("classNumber").getBytes("iso-8859-1"), "utf-8"));
        Users u=(Users)request.getSession().getAttribute("user");  /*获取当前会话中的User使用者，判断其是否有查询的权限*/
        List<Class> list=null;
        if(s.getClassNumber()!=null&&s.getClassNumber().length()>0){   /*通过编号来查询教师信息*/
            System.out.println("111");
            Class ss=new FindClassDao().findClassByclassNumber(s.getClassNumber(), u);
            if(ss==null){
                request.setAttribute("msg", "未找到结果！");
                request.getRequestDispatcher("showMessage.jsp").forward(request, response);
            }else{
                list=new ArrayList<Class>();
                list.add(ss);
                request.setAttribute("list", list);
                request.getRequestDispatcher("showClass.jsp").forward(request, response);
            }
        }
        else if(s.getMno()!=null&&s.getMno().length()>0)
        {
            list=new FindClassDao().findClassByMno(s.getMno(), u);
            if(list.size()<=0){
                request.setAttribute("msg", "未找到结果！");
                request.getRequestDispatcher("showMessage.jsp").forward(request, response);
            }else{
                request.setAttribute("list", list);
                request.getRequestDispatcher("showClass.jsp").forward(request, response);
            }
        }
        else{}
    }

}
