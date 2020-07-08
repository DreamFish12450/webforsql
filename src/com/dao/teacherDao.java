package com.dao;

import com.beans.avgCScore;
import com.beans.stuScore;
import com.beans.teacherCourse;
import com.beans.teacherStudents;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class teacherDao extends BaseDao {
    public ArrayList<teacherCourse> getTeacherCourse(String Tno)throws SQLException, ClassNotFoundException{
//        Connection connection = getConn();
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
//        connection.close();
        closeALL(conn,pstmt,rs);
        return tacs;
    }
    public  ArrayList<teacherStudents>  getTeacherStudents(String Tno) throws SQLException {
        String sql = "select zky_Sno08,zky_Sname08,zky_Cname08,zky_openSemester08,zky_Cno08,zky_Score08 from TeacherStudents where zky_Tno08 = ?";
        ArrayList<teacherStudents> tss = new ArrayList<teacherStudents>();
        String []args = new String[1];
        args[0] = Tno;
        ResultSet rs = executeQuerySQL(sql,args);
        while(rs.next()){
            teacherStudents temp = new teacherStudents();
            temp.setSno(rs.getString(1));
            temp.setSname(rs.getString(2));
            temp.setCname(rs.getString(3));
            temp.setOpensemester(rs.getString(4));
            temp.setCno(rs.getString(5));
            temp.setScore(rs.getInt(6));
            tss.add(temp);
        }
        closeALL(conn,pstmt,rs);
        return tss;
    }
    public void updateScore(String Sno,String Cno,int Scores) throws SQLException {
        String sql = "update zhouky_Score08 set zky_Score08 = ? where zky_Sno08 = ? and zky_Cno08 = ?";
        Object []args = new Object[3];
        args[0] = Scores;
        args[1] = Sno;
        args[2] = Cno;
        int status = executeUpdate(sql,args);
        if(status == 1){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
        closeALL(conn,pstmt,null);
    }
    public  ArrayList<avgCScore> getClassScore() throws SQLException {
//        Connection connection = getConn();
        String sql="SELECT Zhouky_Score08.zky_Cno08,avg(zky_Score08) avg_score\n" +
                "FROM Zhouky_Score08,Zhouky_Courses08\n" +
                "WHERE Zhouky_Score08.zky_Cno08=Zhouky_Courses08.zky_Cno08\n" +
                "Group by Zhouky_Score08.zky_Cno08";

        ResultSet rs = executeQuerySQL(sql,null);
        ArrayList<avgCScore> list=new ArrayList<avgCScore>();
       while (rs.next())
        {
            avgCScore temp=new avgCScore();
            temp.setCno(rs.getString(1));
            temp.setAvg_score(rs.getDouble(2));
            System.out.println(temp.getAvg_score()+"here is avgScore");
            list.add(temp);
        }
        closeALL(conn,pstmt,null);
        return list;

    }
}
    


