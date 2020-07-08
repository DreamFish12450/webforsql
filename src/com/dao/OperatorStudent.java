package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.common.JdbcUtil;

import com.beans.Student;
import com.beans.Users;

public class OperatorStudent {
    public void addStudent(Student s,Users u){
        Connection conn=null;
        try{
            conn=JdbcUtil.getConnection(u.getUserName(), u.getPwd());
            conn.setAutoCommit(false);
            String sql="insert into Zhouky_Students08 values(?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, s.getSno());
            ps.setString(2, s.getSname());
            ps.setString(3, s.getSsex());
            ps.setInt(4, s.getSage());
            ps.setString(5, s.getSourceOfStudents());
            ps.setString(6, s.getClassNumber());
            ps.executeUpdate();
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
    public void deleteStudent(String Sno,Users u){
        Connection conn=null;
        try{
            conn=JdbcUtil.getConnection(u.getUserName(), u.getPwd());
            conn.setAutoCommit(false);
            PreparedStatement ps1=conn.prepareStatement("delete from Zhouky_Students08 where zky_Sno08=?");
            ps1.setString(1, Sno);
            ps1.execute();
//            PreparedStatement ps2=conn.prepareStatement("delete Student where Job_number=?");
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
    public void updateStudent(Student s,Users u){
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
    private String getSQL(Student s){
        StringBuffer sb=new StringBuffer("update Zhouky_Students08 set");
        if(s.getSname()!=null&&s.getSname().length()>0)
            sb.append(" zky_Sname08='").append(s.getSname()).append("',");
        if(s.getSsex()!=null&&s.getSsex().length()>0)
            sb.append(" zky_Ssex08='").append(s.getSsex()).append("',");
        if(s.getSage()>0)
            sb.append(" zky_Sage08=").append(s.getSage()).append(",");
        if(s.getSourceOfStudents()!=null&&s.getSourceOfStudents().length()>0)
            sb.append(" zky_sourceOfStudents08='").append(s.getSourceOfStudents()).append("',");
        if(s.getClassNumber()!=null&&s.getClassNumber().length()>0)
            sb.append(" zky_classNumber08='").append(s.getClassNumber()).append("',");
        sb.append(" zky_Sno08='").append(s.getSno()).append("' where zky_Sno08='").append(s.getSno()).append("'");
        System.out.println(sb);
        return sb.toString();
    }
}
