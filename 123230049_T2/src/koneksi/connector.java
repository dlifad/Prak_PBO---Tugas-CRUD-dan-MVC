package koneksi;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Zainur Fadli
 */
public class connector {
    static Connection con;

    public static Connection connection() {
        if (con == null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("movie_db");
            data.setUser("root");
            data.setPassword("");
            data.setServerName("localhost");
            data.setPortNumber(3306);

            try {
                con = data.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Koneksi ke database gagal!");
            }
        }

        return con;
    }
}
 