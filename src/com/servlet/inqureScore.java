package com.servlet;

import com.beans.stuScore;
import com.dao.stuDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
@WebServlet("/inqureScore.do")
public class inqureScore extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        stuDao stuDao = new stuDao();
        String Sno = "S01";
        String ose = request.getParameter("semester");
        try {
            ArrayList<stuScore> scores = stuDao.getScore(Sno,ose);
//            System.out.println("debug"+scores.get(1).getSno());

            request.setAttribute("sno",Sno);
            request.setAttribute("scores",scores);
            request.setAttribute("open_semester",ose);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/inqureScoreResult.jsp");
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
