package com.servlet;

import com.beans.*;
import com.dao.stuDao;
import com.dao.teacherDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
@WebServlet("/inqureAvgClass.do")
public class inqureAvgClass extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        teacherDao tDao = new teacherDao();
       // String Sno = request.getParameter("Sno1");
       // String ose = request.getParameter("semester");
        try {
            ArrayList<avgCScore> list = tDao.getClassScore();
//            System.out.println("debug"+scores.get(1).getSno());
            System.out.println("itsSize"+list.size());
            request.setAttribute("list",list);
//            request.setAttribute("sno",Sno);
 //           request.setAttribute("scores",scores);
  //          request.setAttribute("open_semester",ose);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/inqureAVGClass.jsp");
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}