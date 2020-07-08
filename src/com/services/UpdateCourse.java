package com.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OperatorCourse;

import com.beans.Course;
import com.beans.Users;
@WebServlet("/UpdateCourse")
public class UpdateCourse extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Course s=new Course();
        s.setCno(new String(request.getParameter("Cno").getBytes("iso-8859-1"), "utf-8"));
        s.setOpenSemester(new String(request.getParameter("openSemester").getBytes("iso-8859-1"), "utf-8"));
        s.setCname(new String(request.getParameter("Cname").getBytes("iso-8859-1"), "utf-8"));
        String Chours=new String(request.getParameter("Chours").getBytes("iso-8859-1"), "utf-8");
        if(Chours!=null&&Chours.length()>0){
            s.setChours(Integer.parseInt(Chours));
        }else
            s.setChours(0);
        s.setNatureofAssessment(new String(request.getParameter("natureofAssessment").getBytes("iso-8859-1"), "utf-8"));
        String Credit=new String(request.getParameter("Credit").getBytes("iso-8859-1"), "utf-8");
        if(Credit!=null&&Credit.length()>0){
            s.setCredit(Integer.parseInt(Credit));
        }else
            s.setCredit(0);
        OperatorCourse os=new OperatorCourse();
        Users u=(Users)request.getSession().getAttribute("user");
        os.updateCourse(s, u);
        request.setAttribute("msg", "修改成功！");
        request.getRequestDispatcher("showMessage.jsp").forward(request, response);
    }
}
