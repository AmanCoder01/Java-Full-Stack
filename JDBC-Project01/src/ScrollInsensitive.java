import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollInsensitive {
    // 1. Load the driver class
    // 2. Get connection from db
    // 3 . create statement
    // 4 . Execute query

    public static void main(String[] args)  {
       try{
           Class.forName("com.mysql.cj.jdbc.Driver"); // load driver class

           Connection connection = DriverManager.getConnection(
                   "jdbc:mysql://localhost:3306/mydb",
                   "root",
                   "1234");

           Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

           String query = "SELECT * FROM student";

           ResultSet rs = statement.executeQuery(query);

            rs.last();
           System.out.println("LAST Row"+rs.getInt("id"));
           System.out.println("LAST Row"+rs.getString("name"));

            rs.first();
           System.out.println("First Row"+rs.getInt("id"));
           System.out.println("First Row"+rs.getString("name"));

            rs.absolute(2);
           System.out.println("Second Row"+rs.getInt("id"));
           System.out.println("Second Row"+rs.getString("name"));


       }catch (Exception e){
           System.out.println("Error");
       }


    }
}
