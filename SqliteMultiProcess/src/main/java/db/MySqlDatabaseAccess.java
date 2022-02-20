package db;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database access class for mysql
 */
public class MySqlDatabaseAccess extends ADatabaseAccess {



    @Override
    public  void connect() throws SQLException {
        var sb = new StringBuilder("jdbc:mysql://");
        sb.append("localhost");
        sb.append(":");
        sb.append("3306");
        sb.append("/databasename");
        sb.append("?useUnicode=true&");
        sb.append("useJDBCCompliantTimezoneShift=true&");
        sb.append("useLegacyDatetimeCode=false&");
        sb.append("serverTimezone=UTC");

        var username = "root";
        var pass = "";

        var conn = sb.toString();

        _connection = DriverManager.getConnection(conn, username, pass);
    }
}
