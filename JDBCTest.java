package com.dcml.cms.controller;

import java.sql.*;

public class JDBCTest {

    public static void main(String[] args){
        try {
            Class.forName("com.mysql.jdbc.Driver");

        }catch (ClassNotFoundException ex){
            System.out.println("找不到驱动程序类！");
        }
        String userName = "root";
        String passWord = "root";
        String url = "jdbc:mysql://mysql.springfans.org:3306/dcml";
        String sql = " select * from uaa_users  where id  =1 ";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(url,userName,passWord);
            stmt = con.createStatement();
            //PreparedStatement pstmt = con.prepareStatement(sql);
            //CallableStatement cstmt = con.prepareCall(sql);
            rs = stmt.executeQuery(sql);
            //int rows = stmt.executeUpdate("insert into ");
            //boolean flag = stmt.execute(sql);

            while(rs.next()){   //遍历每一行 然后处理一行中的对应字段
                String name = rs.getString("username");
                String pass = rs.getString(2);   //通过列数 从左到右 从1 开始
                System.out.println(name+"--"+pass);

            }
        }catch (SQLException ex){
            System.out.println("连接数据库失败！");
        }finally {  //在finally 中关闭资源防止程序执行失败 资源未关闭
            if(rs!=null){
                try {
                    rs.close();
                }catch (SQLException ex){

                }
            }

            if(stmt!=null){
                try {
                    stmt.close();
                }catch (SQLException ex){

                }
            }

            if(con!=null){
                try {
                    con.close();
                }catch (SQLException ex){

                }
            }
        }



    }

}
