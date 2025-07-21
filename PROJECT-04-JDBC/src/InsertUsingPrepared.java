import java.sql.*;

public class InsertUsingPrepared {
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


           String query = "Insert into student (id,name,age) values (?,?,?);";

           PreparedStatement ps = connection.prepareStatement(query);

           ps.setInt(1,54);
           ps.setString(2,"Thdf");
           ps.setInt(3,34);

           int update = ps.executeUpdate();
           System.out.println("updated"+ update);

       }catch (Exception e){
           System.out.println("Error");
       }


    }
}
