package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.common.JdbcUtil;

import com.beans.Class;
import com.beans.Users;

public class FindClassDao {
    public Class findClassByclassNumber(String classNumber ,Users u){    //通过编号查询数据库内教师信息
        Connection conn=null;
        Class s=null;
        try {
            conn = JdbcUtil.getConnection(u.getUserName(), u.getPwd()); /*通过User帐号与数据库连接*/
            PreparedStatement ps=conn.prepareStatement("select * from Zhouky_Class08 where zky_classNumber08=?"); /*创建预处理对象，并进行数据库查询*/
            ps.setString(1, classNumber);
            ResultSet rs=ps.executeQuery();  /*resultset对象表示select语句查询得到的记录集合*/
            while(rs.next()){ /*遍历select语句查询得到的记录表*/
                s=new Class();
                s.setClassNumber(rs.getString(1));
                s.setMno(rs.getString(2));
                s.setClassSize(rs.getInt(3));
                s.setIsExperimental(rs.getString(4));
                s.setClassName(rs.getString(5));
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
    public List<Class> findClassByMno(String Mno,Users u){
        Connection conn=null;
        List<Class> list=new ArrayList<Class>();
        try{
            conn=JdbcUtil.getConnection(u.getUserName(), u.getPwd());
            PreparedStatement ps=conn.prepareStatement("select * from Zhouky_Class08 where zky_Mno08=?");
            ps.setString(1, Mno);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Class s=new Class();
                s.setClassNumber(rs.getString(1));
                s.setMno(rs.getString(2));
                s.setClassSize(rs.getInt(3));
                s.setIsExperimental(rs.getString(4));
                s.setClassName(rs.getString(5));
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
//    private String getSQL(Class s){
//        StringBuffer sb=new StringBuffer("select * from Class where 1=1");
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
