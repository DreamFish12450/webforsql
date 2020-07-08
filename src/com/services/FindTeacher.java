package com.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FindTeacherDao;
import com.beans.Teacher;
import com.beans.Users;
@WebServlet("/FindTeacher")
public class FindTeacher extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Teacher s=new Teacher();   /*获取存在request中员工的基本信息，并建立员工对象*/
        s.setTno(new String(request.getParameter("Tno").getBytes("iso-8859-1"), "utf-8"));
        s.setTname(new String(request.getParameter("Tname").getBytes("iso-8859-1"), "utf-8"));
        s.setTtitle(new String(request.getParameter("Ttitle").getBytes("iso-8859-1"), "utf-8"));
        Users u=(Users)request.getSession().getAttribute("user");  /*获取当前会话中的User使用者，判断其是否有查询的权限*/
        List<Teacher> list=null;
        if(s.getTno()!=null&&s.getTno().length()>0){   /*通过编号来查询教师信息*/
            System.out.println("111");
            Teacher ss=new FindTeacherDao().findTeacherByTno(s.getTno(), u);
            if(ss==null){
                request.setAttribute("msg", "未找到结果！");
                request.getRequestDispatcher("showMessage.jsp").forward(request, response);
            }else{
                list=new ArrayList<Teacher>();
                list.add(ss);
                request.setAttribute("list", list);
                request.getRequestDispatcher("showTeacher.jsp").forward(request, response);
            }
        }else if(s.getTname()!=null&&s.getTname().length()>0){  /*通过姓名查询教师信息*/
            System.out.println("222"+s.getTname());
            Teacher ss=new FindTeacherDao().findTeacherByTname(s.getTname(), u);
            if(ss==null){
                request.setAttribute("msg", "未找到结果！");
                request.getRequestDispatcher("showMessage.jsp").forward(request, response);
            }else{
                list=new ArrayList<Teacher>();
                list.add(ss);
                request.setAttribute("list", list);
                request.getRequestDispatcher("showTeacher.jsp").forward(request, response);
            }
        }else if(s.getTtitle()!=null&&s.getTtitle().length()>0){
            list=new FindTeacherDao().findTeachersByTtitle(s.getTtitle(), u);
            if(list.size()<=0){
                request.setAttribute("msg", "未找到结果！");
                request.getRequestDispatcher("showMessage.jsp").forward(request, response);
            }else{
                request.setAttribute("list", list);
                request.getRequestDispatcher("showTeacher.jsp").forward(request, response);
            }
        }
        else{}
    }

}
