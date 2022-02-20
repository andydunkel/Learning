package db;

import org.sqlite.SQLiteConfig;

import java.sql.SQLException;

/**
 * Datebase access class for the sqlite database
 */
public class SqliteDatabaseAccess extends ADatabaseAccess {

    @Override
    public void connect() throws SQLException {
        org.sqlite.SQLiteConfig config = new org.sqlite.SQLiteConfig();
        config.enforceForeignKeys(true);
        config.setSynchronous(SQLiteConfig.SynchronousMode.FULL);
        config.setJournalMode(SQLiteConfig.JournalMode.WAL);
        config.enableFullSync(true);

        var connString = "jdbc:sqlite:db.sqlite";
        _connection = config.createConnection(connString);
    }



    //config.setUserVersion(3);
    //

}
