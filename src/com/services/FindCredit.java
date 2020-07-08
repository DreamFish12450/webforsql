package com.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FindCreditDao;
import com.beans.Credit;
import com.beans.Users;
@WebServlet("/FindCredit.do")
public class FindCredit extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String option = new String(request.getParameter("Sno").getBytes("iso-8859-1"), "utf-8");
        Credit s=new Credit();   /*获取存在request中员工的基本信息，并建立员工对象*/
        s.setSno(new String(request.getParameter("Sno").getBytes("iso-8859-1"), "utf-8"));
        Users u=(Users)request.getSession().getAttribute("user");  /*获取当前会话中的User使用者，判断其是否有查询的权限*/
        List<Credit> list2=null;
        if(s.getSno()!=null&&s.getSno().length()>0&&option.equals("查询一个学生")){   /*通过工号来查询员工信息*/
            list2 = new FindCreditDao().findCreditBySno(s.getSno(), u);
            if(list2.size()<=0){
                request.setAttribute("msg", "未找到结果！");
                request.getRequestDispatcher("showMessage.jsp").forward(request, response);
            }else{
                request.setAttribute("list2", list2);
                request.getRequestDispatcher("inqureAllCreditResult.jsp").forward(request, response);
            }
        }
        else {/*找出所有数据库中员工信息*/
            list2=new FindCreditDao().findCreditsByall(u);
            if(list2.size()<=0){
                request.setAttribute("msg", "未找到结果！");
                request.getRequestDispatcher("showMessage.jsp").forward(request, response);
            }else{
                request.setAttribute("list2", list2);
                request.getRequestDispatcher("inqureAllCreditResult.jsp").forward(request, response);
            }
        }
    }

}
