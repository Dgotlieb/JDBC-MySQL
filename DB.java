import java.sql.*;

public class DB {
    private static final String USER_NAME = "szswnaapzk";
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://remotemysql.com:3306", USER_NAME, "6mgTl1Slou");
        
//        createTable(con);
//        insertStudent(con, 123, "daniel");
//        getTableContent(con);
//        deleteStudentByName(con, "daniel");
//        updateStudentGrade(con,123, "John");
    }

    private static void createTable(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        String statementToExecute = "CREATE TABLE '"+USER_NAME+"'.`users`(`id` INT NOT NULL,`name` VARCHAR(45) NOT NULL, PRIMARY KEY (`id`));";
        stmt.execute(statementToExecute);
    }

    private static void insertStudent(Connection con, int id, String name) throws SQLException {
        String statementToExecute = "";
        Statement stmt = con.createStatement();
        statementToExecute = "INSERT INTO "+USER_NAME+".users (`id`, `name`) VALUES ('" + id + "', '" + name + "');";
        stmt.execute(statementToExecute);
    }

    private static void getTableContent(Connection con) throws SQLException {
        String statementToExecute = "SELECT * FROM "+USER_NAME+".users;";
        Statement stmt = con.createStatement();
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
    private static void deleteStudentByName(Connection con, String name) throws SQLException {
        //Execute a query
        String statementToExecute = "";
        Statement stmt = con.createStatement();
        statementToExecute = "DELETE FROM `"+USER_NAME+"`.`users` WHERE `name`='"+name+"';";
        stmt.execute(statementToExecute);
    }

    private static void updateStudentGrade(Connection con, int id, String name) throws SQLException {
        //Execute a query
        String statementToExecute = "";
        Statement stmt = con.createStatement();
        statementToExecute = "UPDATE `"+USER_NAME+"`.`users` SET `name`='"+name+"' WHERE `id`='"+id+"';";
        stmt.executeUpdate(statementToExecute);
    }
}
