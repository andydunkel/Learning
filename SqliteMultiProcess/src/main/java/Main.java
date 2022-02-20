import db.SqliteDatabaseAccess;

import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        var random = new Random();
        int currentRandomId = random.nextInt(10 - 1) + 1;
        var db = new SqliteDatabaseAccess();
        try {
            db.connect();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            try {
                var sql = "INSERT INTO log (text) values (?)";
                var statement = db.prepareStatement(sql);
                var currentText = "Log Entry  - " + UUID.randomUUID().toString() + " - process: " + currentRandomId;
                statement.setString(1, currentText);
                statement.execute();
                Thread.sleep(100);

                var sqlSelect = "SELECT * FROM log ORDER BY ID DESC";
                var selectStatement = db.prepareStatement(sqlSelect);
                var result = selectStatement.executeQuery();
                if (result.next()) {
                    System.out.println("Last row: " + result.getInt("id") + " - " + result.getString("text"));
                }

                var sqlCount = "SELECT count(*) FROM log";
                var countStatement = db.prepareStatement(sqlCount);
                var resultCount = countStatement.executeQuery();
                resultCount.next();
                System.out.println("Table contains " + resultCount.getInt("count(*)") + " rows");

                statement.close();
                result.close();

                resultCount.close();
                selectStatement.close();
                countStatement.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
