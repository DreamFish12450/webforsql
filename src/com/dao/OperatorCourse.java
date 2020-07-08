package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.common.JdbcUtil;

import com.beans.Course;
import com.beans.Users;

public class OperatorCourse {
public void addCourse(Course s,Users u){
        Connection conn=null;
        try{
        conn=JdbcUtil.getConnection(u.getUserName(), u.getPwd());
        conn.setAutoCommit(false);
        String sql="insert into Zhouky_Courses08 values(?,?,?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1, s.getCno());
        ps.setString(2, s.getOpenSemester());
        ps.setString(3, s.getCname());
        ps.setInt(4, s.getChours());
        ps.setString(5, s.getNatureofAssessment());
        ps.setInt(6, s.getCredit());
        ps.execute();
        conn.commit();
        }catch(SQLException e){
        JdbcUtil.rollbackConnection(conn);
        e.printStackTrace();
        }catch(Exception e){
        e.printStackTrace();
        }finally{
        JdbcUtil.closeConnection(conn);
        }
        }
public void deleteCourse(String Cno, String openSemester,Users u){
        Connection conn=null;
        try{
        conn=JdbcUtil.getConnection(u.getUserName(), u.getPwd());
        conn.setAutoCommit(false);
        PreparedStatement ps1=conn.prepareStatement("delete from Zhouky_Courses08 where zky_Cno08=? and zky_openSemester08=?");
        ps1.setString(1, Cno);
        ps1.setString(2, openSemester);
        ps1.execute();
//            PreparedStatement ps2=conn.prepareStatement("delete Course where Job_number=?");
//            ps2.setString(1, Tno);
//            ps2.execute();
        conn.commit();
        }catch(SQLException e){
        JdbcUtil.rollbackConnection(conn);
        e.printStackTrace();
        }catch(Exception e){
        e.printStackTrace();
        }finally{
        JdbcUtil.closeConnection(conn);
        }
        }
public void updateCourse(Course s,Users u){
        Connection conn=null;
        try{
        conn=JdbcUtil.getConnection(u.getUserName(), u.getPwd());
        conn.setAutoCommit(false);
        PreparedStatement ps=conn.prepareStatement(this.getSQL(s));
        ps.execute();
        conn.commit();
        }catch(SQLException e){
        JdbcUtil.rollbackConnection(conn);
        e.printStackTrace();
        }catch(Exception e){
        e.printStackTrace();
        }finally{
        JdbcUtil.closeConnection(conn);
        }
        }
private String getSQL(Course s){
        StringBuffer sb=new StringBuffer("update Zhouky_Courses08 set");
        if(s.getOpenSemester()!=null&&s.getOpenSemester().length()>0)
        sb.append(" zky_openSemester08='").append(s.getOpenSemester()).append("',");
        if(s.getCname()!=null&&s.getCname().length()>0)
        sb.append(" zky_Cname08='").append(s.getCname()).append("',");
        if(s.getChours()>0)
        sb.append(" zky_Chours08=").append(s.getChours()).append(",");
        if(s.getNatureofAssessment()!=null&&s.getNatureofAssessment().length()>0)
        sb.append(" zky_natureofAssessment08='").append(s.getNatureofAssessment()).append("',");
        if(s.getCredit()>0) sb.append(" zky_credit08='").append(s.getCredit()).append("',");
        sb.append(" zky_Cno08='").append(s.getCno()).append("' where zky_Cno08='").append(s.getCno()).append("'");
        System.out.println(sb);
        return sb.toString();
        }
        }
