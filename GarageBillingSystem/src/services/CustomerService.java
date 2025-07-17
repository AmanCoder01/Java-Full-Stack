package services;

import config.DbConnection;
import entities.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public void addCustomer(Customer customer) throws SQLException {
        Connection conn = DbConnection.getConnection();

        PreparedStatement ps = conn.prepareStatement("INSERT INTO customer(name,phone) VALUES (?,?)");
        ps.setString(1,customer.getName());
        ps.setString(2,customer.getPhone());

        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public Customer getCustomerByPhone(String phone) throws SQLException {
      Customer customer = new Customer();

        Connection conn = DbConnection.getConnection();
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM customer WHERE phone="+phone);

        while (rs.next()){
            customer.setId(rs.getInt("id"));
            customer.setName(rs.getString("name"));
            customer.setPhone(rs.getString("phone"));
        }

        return customer;
    }

    public List<Customer> getAllCustomer() throws SQLException {
        List<Customer> list = new ArrayList<>();

        Connection conn = DbConnection.getConnection();
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM customer");

        while (rs.next()){
            list.add(new Customer(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone")
            ));
        }

        return list;
    }
}
