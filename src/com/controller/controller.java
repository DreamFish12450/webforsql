package com.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class controller extends HttpServlet {
   public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
              throws IOException,ServletException {
       String action = request.getParameter("action");
       //System.out.println("here is action"+action);
       if (action.equalsIgnoreCase("login.do")) {
           request.getRequestDispatcher("/login").forward(request,response);
       }
       if (action.equalsIgnoreCase("admin.do")) {
           request.getRequestDispatcher("admin.jsp").forward(request,response);
       }
       if (action.equalsIgnoreCase("logination.do")) {
           request.getRequestDispatcher("logination.jsp").forward(request,response);
       }
       //------------------------------------------------------------------------------
       if(action.equalsIgnoreCase("FindTeacher.do"))
       {
           request.getRequestDispatcher("/FindTeacher").forward(request,response);
       }
       if(action.equalsIgnoreCase("AddTeacher.do"))
       {
           request.getRequestDispatcher("/AddTeacher").forward(request,response);
       }
       if(action.equalsIgnoreCase("PreUpdateTeacher.do"))
       {

           request.getRequestDispatcher("/PreUpdateTeacher").forward(request,response);
       }
       if(action.equalsIgnoreCase("DeleteTeacher.do"))
       {
           request.getRequestDispatcher("/DeleteTeacher").forward(request,response);
       }
       if(action.equalsIgnoreCase("UpdateTeacher.do"))
       {
           request.getRequestDispatcher("/UpdateTeacher").forward(request,response);
       }
       //------------------------------------------------------------------------------
       if(action.equalsIgnoreCase("FindStudent.do"))
       {
           request.getRequestDispatcher("/FindStudent").forward(request,response);
       }
       if(action.equalsIgnoreCase("AddStudent.do"))
       {
           request.getRequestDispatcher("/AddStudent").forward(request,response);
       }
       if(action.equalsIgnoreCase("PreUpdateStudent.do"))
       {

           request.getRequestDispatcher("/PreUpdateStudent").forward(request,response);
       }
       if(action.equalsIgnoreCase("DeleteStudent.do"))
       {
           request.getRequestDispatcher("/DeleteStudent").forward(request,response);
       }
       if(action.equalsIgnoreCase("UpdateStudent.do"))
       {
           request.getRequestDispatcher("/UpdateStudent").forward(request,response);
       }
       //------------------------------------------------------------------------------
       if(action.equalsIgnoreCase("FindClass.do"))
       {
           request.getRequestDispatcher("/FindClass").forward(request,response);
       }
       if(action.equalsIgnoreCase("AddClass.do"))
       {
           request.getRequestDispatcher("/AddClass").forward(request,response);
       }
       if(action.equalsIgnoreCase("PreUpdateClass.do"))
       {

           request.getRequestDispatcher("/PreUpdateClass").forward(request,response);
       }
       if(action.equalsIgnoreCase("DeleteClass.do"))
       {
           request.getRequestDispatcher("/DeleteClass").forward(request,response);
       }
       if(action.equalsIgnoreCase("UpdateClass.do"))
       {
           request.getRequestDispatcher("/UpdateClass").forward(request,response);
       }
       //------------------------------------------------------------------------------
       if(action.equalsIgnoreCase("FindCourse.do"))
       {
           request.getRequestDispatcher("/FindCourse").forward(request,response);
       }
       if(action.equalsIgnoreCase("AddCourse.do"))
       {
           request.getRequestDispatcher("/AddCourse").forward(request,response);
       }
       if(action.equalsIgnoreCase("PreUpdateCourse.do"))
       {

           request.getRequestDispatcher("/PreUpdateCourse").forward(request,response);
       }
       if(action.equalsIgnoreCase("DeleteCourse.do"))
       {
           request.getRequestDispatcher("/DeleteCourse").forward(request,response);
       }
       if(action.equalsIgnoreCase("UpdateCourse.do"))
       {
           request.getRequestDispatcher("/UpdateCourse").forward(request,response);
       }
       //------------------------------------------------------------------------------
       if(action.equalsIgnoreCase("FindDistrict.do"))
       {
           request.getRequestDispatcher("/FindDistrict").forward(request,response);
       }
       //------------------------------------------------------------------------------
       if(action.equalsIgnoreCase("FindWage.do"))
       {
           request.getRequestDispatcher("FindWage").forward(request,response);
       }
       if(action.equalsIgnoreCase("AddWage.do"))
       {
           request.getRequestDispatcher("/AddWage").forward(request,response);
       }
       if(action.equalsIgnoreCase("UpdateWage.do"))
       {
           request.getRequestDispatcher("/UpdateWage").forward(request,response);
       }
       if(action.equalsIgnoreCase("FindDepart.do"))
       {
           request.getRequestDispatcher("/FindDepart").forward(request,response);
       }
   }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
} 

