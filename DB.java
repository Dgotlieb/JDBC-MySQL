import java.sql.*;

public class DB {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://remotemysql.com:3306", "szswnaapzk", "6mgTl1Slou");
        Statement stmt = con.createStatement();
//        createTable(stmt);
//        insertStudent(con, 123, "daniel");
//        getTableContent(stmt);
    }

    private static void createTable(Statement stmt) throws SQLException {
        String statementToExecute2 = "CREATE TABLE `szswnaapzk`.`users`(`id` INT NOT NULL,`name` VARCHAR(45) NOT NULL, PRIMARY KEY (`id`));";
        stmt.execute(statementToExecute2);
    }

    private static void insertStudent(Connection con, int id, String name) throws SQLException {
        String statementToExecute = "";
        Statement stmt = con.createStatement();
        statementToExecute = "INSERT INTO `szswnaapzk`.`users` (`id`, `name`) VALUES ('" + id + "', '" + name + "');";
        stmt.execute(statementToExecute);
    }

    private static void getTableContent(Statement stmt) throws SQLException {
        String statementToExecute = "SELECT * FROM szswnaapzk.users;";
        ResultSet rs = stmt.executeQuery(statementToExecute);
        while(rs.next()){
            //Retrieve by column name
            int id  = rs.getInt("id");
            String name = rs.getString("name");

            //Display values
            System.out.print("ID: " + id);
            System.out.print(", Name: " + name);
        }

    }
}
