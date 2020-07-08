package com.servlet;

import com.beans.teacherCourse;
import com.beans.teacherStudents;
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
@WebServlet("/inqureTeacherStudents.do")
public class inqureTeacherStu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        teacherDao tdao = new teacherDao();

        try {

            HttpSession session =  request.getSession(true);
//            String Tno = (String) session.getAttribute("Tno");
            String Tno = "T02";
            System.out.println(Tno);

            ArrayList<teacherStudents> tass = tdao.getTeacherStudents(Tno);
//            System.out.println("debug"+scores.get(1).getSno());
            System.out.println("its size"+tass.size());

            request.setAttribute("tass",tass);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/updateStudentResult.jsp");
        rd.forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
