package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.common.JdbcUtil;

import com.beans.Teacher;
import com.beans.Users;

public class OperatorTeacher {
    public void addTeacher(Teacher s,Users u){
        Connection conn=null;
        try{
            conn=JdbcUtil.getConnection(u.getUserName(), u.getPwd());
            conn.setAutoCommit(false);
            String sql="insert into Zhouky_Teacher08 values(?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, s.getTno());
            ps.setString(2, s.getTname());
            ps.setString(3, s.getTsex());
            ps.setInt(4, s.getTage());
            ps.setString(5, s.getTtitle());
            ps.setString(6, s.getTphone());
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
    public void deleteTeacher(String Tno,Users u){
        Connection conn=null;
        try{
            conn=JdbcUtil.getConnection(u.getUserName(), u.getPwd());
            conn.setAutoCommit(false);
            PreparedStatement ps1=conn.prepareStatement("delete from Zhouky_Teacher08 where zky_Tno08=?");
            ps1.setString(1, Tno);
            ps1.execute();
//            PreparedStatement ps2=conn.prepareStatement("delete Teacher where Job_number=?");
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
    public void updateTeacher(Teacher s,Users u){
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
    private String getSQL(Teacher s){
        StringBuffer sb=new StringBuffer("update Zhouky_Teacher08 set");
        if(s.getTname()!=null&&s.getTname().length()>0)
            sb.append(" zky_Tname08='").append(s.getTname()).append("',");
        if(s.getTsex()!=null&&s.getTsex().length()>0)
            sb.append(" zky_Tsex08='").append(s.getTsex()).append("',");
        if(s.getTage()>0)
            sb.append(" zky_Tage08=").append(s.getTage()).append(",");
        if(s.getTtitle()!=null&&s.getTtitle().length()>0)
            sb.append(" zky_Ttitle08='").append(s.getTtitle()).append("',");
        if(s.getTphone()!=null&&s.getTphone().length()>0)
            sb.append(" zky_Tphone08='").append(s.getTphone()).append("',");
        sb.append(" zky_Tno08='").append(s.getTno()).append("' where zky_Tno08='").append(s.getTno()).append("'");
        System.out.println(sb);
        return sb.toString();
    }
}
