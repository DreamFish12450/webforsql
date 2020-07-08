package com.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OperatorTeacher;
import com.beans.Teacher;
import com.beans.Users;
@WebServlet("/AddTeacher")
public class AddTeacher extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Teacher s=new Teacher();
        System.out.println(request.getParameter("Tno1")+123);
        s.setTno(new String(request.getParameter("Tno1").getBytes("iso-8859-1"), "utf-8"));
        s.setTname(new String(request.getParameter("Tname1").getBytes("iso-8859-1"), "utf-8"));
        s.setTsex(new String(request.getParameter("Tsex1").getBytes("iso-8859-1"), "utf-8"));
        String age=new String(request.getParameter("Tage1").getBytes("iso-8859-1"), "utf-8");
        if(age!=null&&age.length()>0){
            s.setTage(Integer.parseInt(age));
        }else
            s.setTage(0);
        s.setTtitle(new String(request.getParameter("Ttitle1").getBytes("iso-8859-1"), "utf-8"));
        s.setTphone(new String(request.getParameter("Tphone1").getBytes("iso-8859-1"), "utf-8"));
        OperatorTeacher os=new OperatorTeacher();
        Users u=(Users)request.getSession().getAttribute("user");
        os.addTeacher(s, u);  /*判断当前用户是否有插入权限，若有则向数据库中插入数据*/
        request.setAttribute("msg", "添加成功！");
        request.getRequestDispatcher("showMessage.jsp").forward(request, response);
    }

}
