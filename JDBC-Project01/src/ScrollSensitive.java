import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollSensitive {
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

           Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

           String query = "SELECT * FROM student";

           ResultSet rs = statement.executeQuery(query);

           System.out.println("Fetch data in live mode update not work...");

           Thread.sleep(10000);
           rs.beforeFirst();

           while (rs.next()){
               System.out.println(
                       rs.getInt("id")+ " | "
                               + rs.getString("name")+ " | "
                               + rs.getInt("age")
               );
           }


       }catch (Exception e){
           System.out.println("Error");
       }


    }
}
