package connecttosql;

/*import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class ConnectToSQL {
    public static void main(String[] args) {
        var server = "PHI-THUAN\\SQLEXPRESS";
        var user = "phithuan";
        var password = "thuan";
        var db = "HQTCSDL_B1_QLSV";
        var port = 1433;

        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(user);
        ds.setPassword(password);
        ds.setDatabaseName(db);
        ds.setServerName(server);
        ds.setPortNumber(port);

        try (Connection conn = ds.getConnection()) {
            if (conn != null) {
                System.out.println("Connected to SQL Server successfully!");
            } else {
                System.out.println("Failed to connect to SQL Server.");
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to SQL Server: " + e.getMessage());
        }
    }
}*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToSQL {

    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://PHI-THUAN\\SQLEXPRESS:1433;databaseName=HQTCSDL_B1vsB2_QLSV;user=phithuan;password=thuan;encrypt=true;Trusted_Connection=true;trustServerCertificate=true";

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement()) {

            String SQL = "SELECT * FROM SINHVIEN"; // Thử truy vấn bất kỳ
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                System.out.println("MaSV: " + rs.getString("MaSV"));
                System.out.println("HoTEN: " + rs.getString("HoTEN"));
                System.out.println("MaLOP: " + rs.getString("MaLOP"));
                System.out.println("GioiTinh: " + rs.getString("GioiTinh"));
                System.out.println("NgaySinh: " + rs.getString("NgaySinh"));
                System.out.println("DiaChi: " + rs.getString("DiaChi"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

