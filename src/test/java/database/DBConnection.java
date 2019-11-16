package database;

import lombok.extern.java.Log;

import java.sql.*;

@Log
public class DBConnection {
    private String url = "jdbc:postgresql://beta.cfc2wyoyqzbt.eu-central-1.rds.amazonaws.com:5432/qa";
    private String user = "root";
    private String password = "54TY%fgHw&2K";

    public Connection connectToDB() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void verifyUser(String user) {
        DBConnection dbConnection = new DBConnection();
        String updateUserVerified = "Update account_emailaddress set verified = true\n" +
                "where email = ?";


        try(Connection connection = dbConnection.connectToDB();
            PreparedStatement pstms = connection.prepareStatement(updateUserVerified)) {
            pstms.setString(1, user);

        }catch (SQLException e){
          log.info(e.getMessage());
        }
    }
}
