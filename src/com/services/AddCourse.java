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
@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Course s=new Course();
        System.out.println(request.getParameter("Tno1")+123);
        s.setCno(new String(request.getParameter("Cno1").getBytes("iso-8859-1"), "utf-8"));
        s.setOpenSemester(new String(request.getParameter("openSemester1").getBytes("iso-8859-1"), "utf-8"));
        s.setCname(new String(request.getParameter("Cname1").getBytes("iso-8859-1"), "utf-8"));
        String Chours=new String(request.getParameter("Chours1").getBytes("iso-8859-1"), "utf-8");
        if(Chours!=null&&Chours.length()>0){
            s.setChours(Integer.parseInt(Chours));
        }else
            s.setChours(0);
        s.setNatureofAssessment(new String(request.getParameter("natureofAssessment1").getBytes("iso-8859-1"), "utf-8"));
        String Credit=new String(request.getParameter("Credit1").getBytes("iso-8859-1"), "utf-8");
        if(Credit!=null&&Credit.length()>0){
            s.setCredit(Integer.parseInt(Credit));
        }else
            s.setCredit(0);
        OperatorCourse os=new OperatorCourse();
        Users u=(Users)request.getSession().getAttribute("user");
        os.addCourse(s, u);  /*判断当前用户是否有插入权限，若有则向数据库中插入数据*/
        request.setAttribute("msg", "添加成功！");
        request.getRequestDispatcher("showMessage.jsp").forward(request, response);
    }

}
