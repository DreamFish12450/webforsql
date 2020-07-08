package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.common.JdbcUtil;

import com.beans.Class;
import com.beans.Users;

public class OperatorClass {
    public void addClass(Class s,Users u){
        Connection conn=null;
        try{
            conn=JdbcUtil.getConnection(u.getUserName(), u.getPwd());
            conn.setAutoCommit(false);
            String sql="insert into Zhouky_Class08 values(?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, s.getMno());
            ps.setString(2, s.getClassNumber());
            ps.setInt(3, s.getClassSize());
            ps.setString(4, s.getIsExperimental());
            ps.setString(5, s.getClassName());
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
    public void deleteClass(String classNumber,Users u){
        Connection conn=null;
        try{
            conn=JdbcUtil.getConnection(u.getUserName(), u.getPwd());
            conn.setAutoCommit(false);
            PreparedStatement ps1=conn.prepareStatement("delete from Zhouky_Class08 where zky_classNumber08=?");
            ps1.setString(1, classNumber);
            ps1.execute();
//            PreparedStatement ps2=conn.prepareStatement("delete Class where Job_number=?");
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
    public void updateClass(Class s,Users u){
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
    private String getSQL(Class s){
        StringBuffer sb=new StringBuffer("update Zhouky_Class08 set");
        if(s.getMno()!=null&&s.getMno().length()>0)
            sb.append(" zky_Mno08='").append(s.getMno()).append("',");
        if(s.getClassSize()>0)
            sb.append(" zky_ClassSize08=").append(s.getClassSize()).append(",");
        if(s.getIsExperimental()!=null&&s.getIsExperimental().length()>0)
            sb.append(" zky_IsExperimental08='").append(s.getIsExperimental()).append("',");
        if(s.getClassName()!=null&&s.getClassName().length()>0)
            sb.append(" zky_ClassName08='").append(s.getClassName()).append("',");
        sb.append(" zky_ClassNumber08='").append(s.getClassNumber()).append("' where zky_ClassNumber08='").append(s.getClassNumber()).append("'");
        System.out.println(sb);
        return sb.toString();
    }
}
