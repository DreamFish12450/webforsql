package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.common.JdbcUtil;

import com.beans.Teacher;
import com.beans.Users;

public class FindTeacherDao {
    public Teacher findTeacherByTno(String Tno,Users u){    //通过编号查询数据库内教师信息
        Connection conn=null;
        Teacher s=null;
        try {
//            System.out.println(Tno);
            conn = JdbcUtil.getConnection(u.getUserName(), u.getPwd()); /*通过User帐号与数据库连接*/
            PreparedStatement ps=conn.prepareStatement("select * from Zhouky_Teacher08 where zky_Tno08=?"); /*创建预处理对象，并进行数据库查询*/
            ps.setString(1, Tno);
            ResultSet rs=ps.executeQuery();  /*resultset对象表示select语句查询得到的记录集合*/
            while(rs.next()){ /*遍历select语句查询得到的记录表*/
                s=new Teacher();
                s.setTno(rs.getString(1));
                s.setTname(rs.getString(2));
                s.setTsex(rs.getString(3));
                s.setTage(rs.getInt(4));
                s.setTtitle(rs.getString(5));
                s.setTphone(rs.getString(6));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JdbcUtil.closeConnection(conn);
        }
        return s;
    }
    public Teacher findTeacherByTname(String Tname,Users u){
        Connection conn=null;
        Teacher s=null;
        try {
            conn = JdbcUtil.getConnection(u.getUserName(), u.getPwd());
            PreparedStatement ps=conn.prepareStatement("select * from Zhouky_Teacher08 where zky_Tname08=?");
            ps.setString(1, Tname);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                s=new Teacher();
                s.setTno(rs.getString(1));
                s.setTname(rs.getString(2));
                s.setTsex(rs.getString(3));
                s.setTage(rs.getInt(4));
                s.setTtitle(rs.getString(5));
                s.setTphone(rs.getString(6));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JdbcUtil.closeConnection(conn);
        }
        return s;
    }
    public List<Teacher> findTeachersByTtitle(String Ttitle,Users u){
        Connection conn=null;
        List<Teacher> list=new ArrayList<Teacher>();
        try{
            conn=JdbcUtil.getConnection(u.getUserName(), u.getPwd());
            PreparedStatement ps=conn.prepareStatement("select * from Zhouky_Teacher08 where zky_Ttitle08=?");
            ps.setString(1, Ttitle);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Teacher s=new Teacher();
                s.setTno(rs.getString(1));
                s.setTname(rs.getString(2));
                s.setTsex(rs.getString(3));
                s.setTage(rs.getInt(4));
                s.setTtitle(rs.getString(5));
                s.setTphone(rs.getString(6));
                list.add(s);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JdbcUtil.closeConnection(conn);
        }
        return list;
    }
//    private String getSQL(Teacher s){
//        StringBuffer sb=new StringBuffer("select * from Teacher where 1=1");
//        if(s.getName()!=null&&s.getName().length()>0)
//            sb.append(" and Name like '%").append(s.getName()).append("%'");
//        if(s.getSex()!=null&&s.getSex().length()>0)
//            sb.append(" and Gender='").append(s.getSex()).append("'");
//        if(s.getAge()>0)
//            sb.append(" and Age=").append(s.getAge());
//        if(s.getDepart()!=null&&s.getDepart().length()>0)
//            sb.append(" and Department like '%").append(s.getDepart()).append("%'");
//        return sb.toString();
//    }
}
