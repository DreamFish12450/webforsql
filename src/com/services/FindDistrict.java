package com.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FindDistrictDao;
import com.beans.District;
import com.beans.Users;
@WebServlet("/FindDistrict")
public class FindDistrict extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        District s=new District();   /*获取存在request中员工的基本信息，并建立员工对象*/
        s.setDistrict(new String(request.getParameter("district").getBytes("iso-8859-1"), "utf-8"));
        System.out.println(request.getParameter("district")+"fuck");
        Users u=(Users)request.getSession().getAttribute("user");  /*获取当前会话中的User使用者，判断其是否有查询的权限*/
        List<District> list2=null;
        if(s.getDistrict()!=null&&s.getDistrict().length()>0){   /*通过工号来查询员工信息*/
            list2 = new FindDistrictDao().findDistrictBydistrict(s.getDistrict(), u);
            if(list2.size()<=0){
                request.setAttribute("msg", "未找到结果！");
                request.getRequestDispatcher("showMessage.jsp").forward(request, response);
            }else{
                request.setAttribute("list2", list2);
                request.getRequestDispatcher("showDistrict.jsp").forward(request, response);
            }
        }
       else {
           System.out.println("wozaizhe");/*找出所有数据库中员工信息*/
            list2=new FindDistrictDao().findDistrictsByall(u);
            if(list2.size()<=0){
                request.setAttribute("msg", "未找到结果！");
                request.getRequestDispatcher("showMessage.jsp").forward(request, response);
            }else{
                request.setAttribute("list2", list2);
                request.getRequestDispatcher("showDistrict.jsp").forward(request, response);
            }
        }
    }

}
