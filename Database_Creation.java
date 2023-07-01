import java.sql.*;

//This class will be used to create the data base for the program itself. The data base will house the information of available jewelries.
public class Database_Creation 
{
    static final String DB_URL = "jdbc:mysql://localhost:3306 /";
    static final String user = "root";
    static final String pass = "";
    public static void main(String[] args) 
    {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, user, pass);
        Statement stmt = conn.createStatement();) 
        {
            String sql = "create database Jewelry_Items";
            stmt.executeUpdate(sql);
            System.out.println("Sucessful creation of the new Data Base");
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}
