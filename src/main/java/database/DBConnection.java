package database;

import lombok.extern.java.Log;

import java.sql.*;

@Log
public class DBConnection {
    private String url = "jdbc:postgresql://translationureed.cfc2wyoyqzbt.eu-central-1.rds.amazonaws.com/translationureed";
    private String user = "root";
    private String password = "F2iOkQWUXjH1wUNqvPCV";

    public Connection connectToDB() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void getUser() {
        DBConnection dbConnection = new DBConnection();
        String updateUserVerified = "SELECT * FROM public.\"user\"\n" +
                "ORDER BY id ASC LIMIT 1";



        try(Connection connection = dbConnection.connectToDB();
            PreparedStatement pstms = connection.prepareStatement(updateUserVerified)) {
            ResultSet rs = pstms.executeQuery();
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  name = rs.getString("email");
                String  address = rs.getString("username");
                String salary = rs.getString("guest_email");
                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "USERNAME = " + address );
                System.out.println( "GUEST EMAIL = " + salary );
            }

        }catch (SQLException e){
            log.info(e.getMessage());
        }

    }

    public void verifyUser(String user){

    }
}
