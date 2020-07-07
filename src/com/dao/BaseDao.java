package com.dao;



import java.sql.*;

/**
 * 数据库访问类
 */
public class BaseDao {
    //数据库驱动
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL数据库引擎;
    //数据库连接地址
    private static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=zhoukeyuMIS08";
    //数据库用户名
    private static String user = "sa";
    //数据库密码
    private static String password = "123456";


    //数据库连接
    protected Connection conn = null;
    //statement对象
    protected PreparedStatement pstmt = null;

    /**
     * 连接数据库
     *
     * @return 数据库连接
     * @throws ClassNotFoundException 未找到驱动类异常
     * @throws SQLException           数据库异常
     */
    protected Connection getConn() throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName(driver);
        //获取连接
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * 数据库查询方法
     *
     * @param sql    预编译sql语句
     * @param params 预编译参数
     * @return 查询结果集
     * @throws SQLException 数据库异常
     */
    protected ResultSet executeQuerySQL(String sql, Object[] params) throws SQLException {
        ResultSet rs = null;
        try {
            conn = getConn();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        pstmt = conn.prepareStatement(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
        }
        rs = pstmt.executeQuery();
        return rs;
    }

    /**
     * 数据库增删改方法
     *
     * @param sql    预编译sql语句
     * @param params 预编译参数
     * @return 数据库影响行数
     * @throws SQLException 数据库异常
     */
    protected int executeUpdate(String sql, Object[] params) throws SQLException {
        try {
            conn = getConn();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int num = 0;
        pstmt = conn.prepareStatement(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
        }
        num = pstmt.executeUpdate();

        return num;
    }

    /**
     * 关闭数据库连接
     * @param conn 数据库连接
     * @param pstmt  statement对象
     * @param rs  ResultSet对象
     */
    protected void closeALL(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                System.out.println("I HAVE CLOSED ALL THE CONNECTION");
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
