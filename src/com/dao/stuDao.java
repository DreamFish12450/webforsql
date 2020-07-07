package com.dao;

import com.beans.stuClass;
import com.beans.stuGpa;
import com.beans.stuScore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class stuDao  extends BaseDao{
    public ArrayList<stuScore>  getScore(String Sno,String openSemester) throws SQLException, ClassNotFoundException {
        Connection connection = getConn();
        String sql = "select * from StuScores where zky_Sno08=? and zky_openSemester08 = ?";
        String []args = new String[2];
        args[0] = Sno;
        args[1] = openSemester;
        ArrayList<stuScore> scores = new ArrayList<stuScore>();
        ResultSet rs = executeQuerySQL(sql,args);
        while (rs.next()){
            stuScore temp = new stuScore();
            temp.setSno(Sno);
//            System.out.println(temp.getSno());


            String Sname = rs.getString(2);
            temp.setSname(Sname);
            temp.setCno( rs.getString(3));
            temp.setCname(new String(rs.getString(4)));
            System.out.println(rs.getString(4));

            temp.setScore(new Integer(rs.getString(6)));
            temp.setOpen_semester(openSemester);
            scores.add(temp);
        }
        closeALL(conn,pstmt,rs);
        return scores;
    }
    public ArrayList<stuClass> getClasses(String className, String semester)throws SQLException, ClassNotFoundException {
        Connection connection = getConn();
        String sql = "select * from ClassCourse where zky_className=? and zky_openSemester08 = ?";
        String []args = new String[2];
        args[0] = className;
        args[1] = semester;
        ArrayList<stuClass> classes = new ArrayList<stuClass>();
        ResultSet rs = executeQuerySQL(sql,args);
        while (rs.next()){
            stuClass temp = new stuClass();
            temp.setClassnumber(rs.getString(1));
            temp.setClassname(rs.getString(2));
            temp.setCno(rs.getString(3));
            temp.setCname(rs.getString(4));
            temp.setOpensemester(rs.getString(5));
            classes.add(temp);
        }
        closeALL(conn,pstmt,rs);
        return classes;
    }
    public ArrayList<stuGpa> getGpa()throws SQLException, ClassNotFoundException {
        Connection connection = getConn();
        String sql = "select * from Stu_GPA";
        String []args = new  String[2];
        ArrayList<stuGpa> gpas = new ArrayList<stuGpa>();
        ResultSet rs = executeQuerySQL(sql,null);
        while (rs.next()){
            stuGpa temp = new stuGpa();
            temp.setSno(rs.getString(1));
            temp.setSname(rs.getString(2));
            temp.setGpa(rs.getDouble(3));
            temp.setRank(rs.getInt(4));
            gpas.add(temp);
        }
        closeALL(conn,pstmt,rs);
        return gpas;
    }
}
