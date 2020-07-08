package com.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Users;

import com.dao.OperatorStudent;
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String Sno=request.getParameter("Sno");
        OperatorStudent os=new OperatorStudent();
        Users u=(Users)request.getSession().getAttribute("user");
        os.deleteStudent(Sno, u);
        request.setAttribute("msg", "删除成功！");
        request.getRequestDispatcher("showMessage.jsp").forward(request, response);
    }

}
