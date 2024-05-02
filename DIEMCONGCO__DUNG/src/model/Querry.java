/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Querry {
    Connection con;
    
    PreparedStatement ps; //ps: Đây là một đối tượng của lớp PreparedStatement, được sử dụng để thực hiện các truy vấn SQL đã được chuẩn bị trước. Chúng ta có thể sử dụng ps để thêm tham số vào truy vấn và thực hiện các thao tác với cơ sở dữ liệu.
    Statement st;//st: Đây là một đối tượng của lớp Statement, được sử dụng để thực hiện các truy vấn SQL không có tham số. Trong ví dụ này, st được sử dụng để thực hiện truy vấn “SELECT MAX(id) FROM admin”.
    ResultSet rs;//rs: Đây là một đối tượng của lớp ResultSet, được sử dụng để lưu trữ kết quả của truy vấn. Trong ví dụ này, rs chứa kết quả của truy vấn “SELECT MAX(id) FROM admin”.

    public void getallSINHVIEN(JTable table) {
        try{
            String connectionUrl = "jdbc:sqlserver://PHI-THUAN\\SQLEXPRESS:1433;databaseName=HQTCSDL_B1vsB2_QLSV;user=phithuan;password=thuan;encrypt=true;Trusted_Connection=true;trustServerCertificate=true"; //con: Đây là một đối tượng của lớp Connection, được sử dụng để kết nối với cơ sở dữ liệu. Trong trường hợp này, nó được khởi tạo bằng MyConnection.getConnection().
            con = DriverManager.getConnection(connectionUrl);
            String sql = "SELECT * FROM SINHVIEN";
            
            con = MyConnection.getConnection(); // Khởi tạo đối tượng Connection
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            Object[] row;

            while (rs.next()) {
                row = new Object[5];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getDouble(3);
                row[3] = rs.getBytes(4);
                row[4] = rs.getBytes(5);

                model.addRow(row);

            }

            model.fireTableDataChanged(); // Cập nhật mô hình của bảng

        }
        catch (Exception e){
            System.out.println("model.Querry.getallSINHVIEN\n" + e);
        }
        
        
    }
    
}
