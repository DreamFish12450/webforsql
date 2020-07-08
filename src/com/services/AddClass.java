package com.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OperatorClass;
import com.beans.Class;
import com.beans.Users;
@WebServlet("/AddClass")
public class AddClass extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Class s=new Class();
        System.out.println(request.getParameter("Tno1")+123);
        s.setMno(new String(request.getParameter("Mno1").getBytes("iso-8859-1"), "utf-8"));
        s.setClassNumber(new String(request.getParameter("classNumber1").getBytes("iso-8859-1"), "utf-8"));
        String classSize=new String(request.getParameter("classSize1").getBytes("iso-8859-1"), "utf-8");
        if(classSize!=null&&classSize.length()>0){
            s.setClassSize(Integer.parseInt(classSize));
        }else
            s.setClassSize(0);
        s.setIsExperimental(new String(request.getParameter("isExperimental1").getBytes("iso-8859-1"), "utf-8"));
        s.setClassName(new String(request.getParameter("className1").getBytes("iso-8859-1"), "utf-8"));
        OperatorClass os=new OperatorClass();
        Users u=(Users)request.getSession().getAttribute("user");
        os.addClass(s, u);  /*判断当前用户是否有插入权限，若有则向数据库中插入数据*/
        request.setAttribute("msg", "添加成功！");
        request.getRequestDispatcher("showMessage.jsp").forward(request, response);
    }

}
