package com.servlet;

import com.beans.stuClass;
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

@WebServlet("/inqureClasses.do")
public class inqureClasses extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        stuDao stuDao = new stuDao();
        String classes = request.getParameter("classes");
        System.out.println("i do here"+classes);
        String ose = request.getParameter("semester");
        try {
            ArrayList<stuClass> classes1 = stuDao.getClasses(classes,ose);
//            System.out.println("debug"+scores.get(1).getSno());

            request.setAttribute("classes",classes);
            request.setAttribute("classarraylist",classes1);
            request.setAttribute("open_semester",ose);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/inqureClassResult.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
