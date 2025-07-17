package services;

import config.DbConnection;
import entities.Customer;
import entities.Invoice;
import entities.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class InvoiceService {

    public int createInvoice(int customerId, int vehicleId, List<Integer> serviceIds) {
        int invoiceId = -1;
        Connection conn = null;
        try {
            conn = DbConnection.getConnection();
            conn.setAutoCommit(false); // Transaction

            // Insert into invoice
            String insertInvoiceSQL = "INSERT INTO invoice (customer_id, vehicle_id) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(insertInvoiceSQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, customerId);
            ps.setInt(2, vehicleId);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                invoiceId = rs.getInt(1);
            }

            // Insert into invoice_service
            String insertServiceSQL = "INSERT INTO invoice_service (invoice_id, service_id) VALUES (?, ?)";
            PreparedStatement serviceStmt = conn.prepareStatement(insertServiceSQL);

            for (int serviceId : serviceIds) {
                serviceStmt.setInt(1, invoiceId);
                serviceStmt.setInt(2, serviceId);
                serviceStmt.addBatch();
            }

            serviceStmt.executeBatch();

            conn.commit(); // Save transaction
            System.out.println("✅ Invoice created with ID: " + invoiceId);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback(); // Rollback on error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return invoiceId;
    }



    public Invoice getInvoiceById(int invoiceId) {
        Invoice invoice = null;
        try (Connection conn = DbConnection.getConnection()) {
            // Get invoice info
            String sql = "SELECT * FROM invoice WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, invoiceId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                invoice = new Invoice();
                invoice.setId(rs.getInt("id"));
                invoice.setCustomerId(rs.getInt("customer_id"));
                invoice.setVehicleId(rs.getInt("vehicle_id"));
                invoice.setDate(rs.getTimestamp("date"));
            }

            // Get services
            String serviceSQL = "SELECT s.id, s.name, s.cost FROM service s " +
                    "JOIN invoice_service isr ON s.id = isr.service_id WHERE isr.invoice_id = ?";
            PreparedStatement psService = conn.prepareStatement(serviceSQL);
            psService.setInt(1, invoiceId);
            ResultSet rsService = psService.executeQuery();

            List<Service> services = new ArrayList<>();
            while (rsService.next()) {
                Service s = new Service();
                s.setId(rsService.getInt("id"));
                s.setName(rsService.getString("name"));
                s.setCost(rsService.getDouble("cost"));
                services.add(s);
            }

            if (invoice != null) {
                invoice.setServices(services);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoice;
    }

}
