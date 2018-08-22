
package com.test.dao;

import com.test.pojo.Uegs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBOper {

    public boolean addUser(String username ,String password){
        boolean bok = false;
        int num = 0;
        Connection conn = new DBHelper(  ).getConn();
        String sql = "insert into ueg ( username,password) values(?,?) ";
        try {
            PreparedStatement pstmt = conn.prepareStatement( sql );
            int i = 1;
            pstmt.setString( i++,username );
            pstmt.setString( i++,password );

            num = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        boolean b = num == 0 ? (bok = false) : (bok = true);
        return bok;
    }

    public Uegs login(Uegs uegs)throws SQLException{
        Connection conn = new DBHelper(  ).getConn();
        String sql =" select * from ueg where username =? and password =? ";

        PreparedStatement pstmt = conn.prepareStatement( sql );
        int i = 1;
        pstmt.setString( i++, uegs.getUsername() );
        pstmt.setString( i++, uegs.getPassword() );
        ResultSet rs = pstmt.executeQuery();

        rs.close();
        pstmt.close();
        conn.close();
        return uegs;
    }
}

