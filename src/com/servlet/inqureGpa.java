package com.servlet;

import com.beans.stuClass;
import com.beans.stuGpa;
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
@WebServlet("/inqureGpa.do")
public class inqureGpa extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        stuDao stuDao = new stuDao();

        try {
            ArrayList<stuGpa> gpas = stuDao.getGpa();
//            System.out.println("debug"+scores.get(1).getSno());


            request.setAttribute("gpas",gpas);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/inqureGpaResult.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
