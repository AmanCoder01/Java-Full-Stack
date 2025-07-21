package services;

import config.DbConnection;
import entities.Vehicle;

import java.sql.*;

public class VehicleService {

    public void addVehicle(Vehicle vehicle) throws SQLException {
        Connection conn = DbConnection.getConnection();

        PreparedStatement ps = conn.prepareStatement("INSERT INTO vehicle(customer_id, number_plate,model) VALUES(?,?,?)");
        ps.setInt(1,vehicle.getCustomerId());
        ps.setString(2,vehicle.getNumberPlate());
        ps.setString(3,vehicle.getModel());

        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public Vehicle getVehicleByCustomerId(int customerId) throws SQLException {
        Vehicle vehicle = new Vehicle();
        Connection conn = DbConnection.getConnection();

        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM vehicle WHERE customer_id="+customerId);

        while (rs.next()){
            vehicle.setId(rs.getInt("id"));
            vehicle.setCustomerId(rs.getInt("customer_id"));
            vehicle.setNumberPlate(rs.getString("number_plate"));
            vehicle.setModel(rs.getString("model"));
        }

        return vehicle;
    }
}
