import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ForwardDirOnly {
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

           Statement statement = connection.createStatement();

           String query = "SELECT * FROM student";

           ResultSet resultSet = statement.executeQuery(query);
           // TYPE_FORWARD_ONLY , CONCURRENT_READ_ONLY; -- default

           System.out.println("Read");
           while (resultSet.next()){
               System.out.println(
                       resultSet.getInt("id")+ " | "
                               + resultSet.getString("name")+ " | "
                                 + resultSet.getInt("age")
               );
           }


       }catch (Exception e){
           System.out.println("Error");
       }


    }
}
