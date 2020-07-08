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
@WebServlet("/UpdateClass")
public class UpdateClass extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Class s=new Class();
        s.setMno(new String(request.getParameter("Mno").getBytes("iso-8859-1"), "utf-8"));
        s.setClassNumber(new String(request.getParameter("classNumber").getBytes("iso-8859-1"), "utf-8"));
        String classSize=new String(request.getParameter("classSize").getBytes("iso-8859-1"), "utf-8");
        if(classSize!=null&&classSize.length()>0){
            s.setClassSize(Integer.parseInt(classSize));
        }else
            s.setClassSize(0);
        s.setIsExperimental(new String(request.getParameter("isExperimental").getBytes("iso-8859-1"), "utf-8"));
        s.setClassName(new String(request.getParameter("className").getBytes("iso-8859-1"), "utf-8"));
        OperatorClass os=new OperatorClass();
        Users u=(Users)request.getSession().getAttribute("user");
        os.updateClass(s, u);
        request.setAttribute("msg", "修改成功！");
        request.getRequestDispatcher("showMessage.jsp").forward(request, response);
    }
}
