package com.servlet;

import com.dao.teacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updateScore.do")
public class updateScore extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] arr1=request.getParameterValues("arr[]");
        Object []arr2 = new Object[3];
        int Score = 0;
        if(arr1!=null) {
            for(int i = 0;i<arr1.length;i++) {
                arr1[i]=arr1[i].replaceAll("\\s*", "");
                if(i == 0){
                    arr2[i] = Integer.parseInt(arr1[i]);
                    Score = (int) arr2[i];
                    System.out.println(arr2[i].getClass());
                }else {
                    arr2[i] = (String)arr1[i];
                }
                System.out.println(arr1[i]);
            }
        }
        teacherDao tDao = new teacherDao();

        try {
            tDao.updateScore(arr1[1],arr1[2],(int)arr2[0]);
            System.out.println("修改成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
