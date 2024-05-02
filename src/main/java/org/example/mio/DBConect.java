package org.example.mio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConect {

    public Connection get_connection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc_vacas", "root", "041130");
            if (con != null) {
                System.out.println("Connection Exitosa");
                return con;
            }
        } catch (SQLException e) {
            System.out.println("HUBO UN ERROR " + e);

            throw new RuntimeException(e);
        }
        return con;
    }
}
