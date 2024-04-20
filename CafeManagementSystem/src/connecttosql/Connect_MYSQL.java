/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connecttosql;

import java.sql.Connection;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Connect_MYSQL {

    public static Connection getJDBConnection() {

        String url = "jdbc:mysql://localhost:3306/cafe2";
        String user = "root";
        String pasworld = "thuan";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(url, user, pasworld);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect_MYSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Connect_MYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public static void main(String[] args) {
        Connection conn = getJDBConnection();

        if (conn != null) 
        {
            System.out.println("kết nối thành công");
        }
        else
        {
            System.out.println("thất bại");
        }
    }
}
