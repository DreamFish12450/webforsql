package com.dao;

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
            System.out.println(temp.getSno());


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
}
