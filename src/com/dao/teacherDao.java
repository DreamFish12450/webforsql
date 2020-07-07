package com.dao;

import com.beans.stuScore;
import com.beans.teacherCourse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class teacherDao extends BaseDao {
    public ArrayList<teacherCourse> getTeacherCourse(String Tno)throws SQLException, ClassNotFoundException{
        Connection connection = getConn();
        String sql = "select * from TeachCourse where zky_Tno08 = ?";

        ArrayList<teacherCourse> tacs = new ArrayList<teacherCourse>();
        String []args = new String[1];
        args[0] = Tno;

        ResultSet rs = executeQuerySQL(sql,args);
        while (rs.next()){
            teacherCourse temp = new teacherCourse();

            temp.setTno(rs.getString(1));
//            System.out.println(temp.getSno());

            temp.setTname(rs.getString(2));
            temp.setCno( rs.getString(3));
            temp.setCname(new String(rs.getString(4)));
            System.out.println(temp.getCname());

            tacs.add(temp);
        }
        closeALL(conn,pstmt,rs);
        return tacs;
    }
}
