package com.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Users;

import com.dao.OperatorTeacher;
@WebServlet("/DeleteTeacher")
public class DeleteTeacher extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String Tno=request.getParameter("Tno");
        OperatorTeacher os=new OperatorTeacher();
        Users u=(Users)request.getSession().getAttribute("user");
        os.deleteTeacher(Tno, u);
        request.setAttribute("msg", "删除成功！");
        request.getRequestDispatcher("showMessage.jsp").forward(request, response);
    }

}
