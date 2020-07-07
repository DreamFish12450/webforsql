package com.servlet;

import com.beans.stuGpa;
import com.beans.teacherCourse;
import com.dao.stuDao;
import com.dao.teacherDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/inqureTeacherCourse.do")
public class inqureTeacherCourse extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        teacherDao tdao = new teacherDao();

        try {

            HttpSession session =  request.getSession(true);
            String Tno = (String) session.getAttribute("Tno");
            System.out.println(Tno);
            ArrayList<teacherCourse> tacs = tdao.getTeacherCourse(Tno);
//            System.out.println("debug"+scores.get(1).getSno());
            System.out.println("its size"+tacs.size());

            request.setAttribute("tacs",tacs);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/inqureTeacherCourseResult.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}