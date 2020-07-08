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
@WebServlet("/UpdateTeacher")
public class UpdateTeacher extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Teacher s=new Teacher();
        s.setTno(new String(request.getParameter("Tno").getBytes("iso-8859-1"), "utf-8"));
        s.setTname(new String(request.getParameter("Tname").getBytes("iso-8859-1"), "utf-8"));
        s.setTsex(new String(request.getParameter("Tsex").getBytes("iso-8859-1"), "utf-8"));
        String age=new String(request.getParameter("Tage").getBytes("iso-8859-1"), "utf-8");
        if(age!=null&&age.length()>0){
            s.setTage(Integer.parseInt(age));
        }else
            s.setTage(0);
        s.setTtitle(new String(request.getParameter("Ttitle").getBytes("iso-8859-1"), "utf-8"));
        s.setTphone(new String(request.getParameter("Tphone").getBytes("iso-8859-1"), "utf-8"));
        OperatorTeacher os=new OperatorTeacher();
        Users u=(Users)request.getSession().getAttribute("user");
        os.updateTeacher(s, u);
        request.setAttribute("msg", "修改成功！");
        request.getRequestDispatcher("showMessage.jsp").forward(request, response);
    }
}
