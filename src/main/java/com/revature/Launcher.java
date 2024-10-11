package com.revature;

import com.revature.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.SQLException;

public class Launcher {

    public static void main(String[] args) {

        try(Connection conn = ConnectionUtil.getConnection()){
            System.out.println("Connection Successful.");
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Connection Failed.");
        }

    }

}
