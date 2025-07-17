package services;

import entities.Customer;
import entities.Invoice;
import entities.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillingService {

    public CustomerService customerService= new CustomerService();
    public InvoiceService invoiceService = new InvoiceService();
    public VehicleService vehicleService = new VehicleService();

    public int createInvoice(int customerId, int vehicleId, List<Integer> serviceIds) throws SQLException {
       return invoiceService.createInvoice(customerId,vehicleId,serviceIds);
    }

    public Invoice getInvoiceById(int id){
        return invoiceService.getInvoiceById(id);
    }

    public void showAllInvoices() throws SQLException{
        List<Invoice> invoiceList = invoiceService.getAllInvoices();

        for(Invoice invoice:invoiceList){
            System.out.println(invoice);
        }
    }


    public void createCustomer(String name, String phone) throws SQLException {

        customerService.addCustomer(new Customer(0,name,phone));
        System.out.println("Customer added Successfully..");
    }

    public Customer getCustomerByPhone(String phone) throws SQLException {
       return customerService.getCustomerByPhone(phone);
    }

    public void showAllCustomers() throws SQLException {
        List<Customer> customerList = customerService.getAllCustomer();

        for(Customer customer:customerList){
            System.out.println(customer);
        }
    }

    public void addVehicle(int customerId,String numberPlate,String model) throws SQLException {
        vehicleService.addVehicle(new Vehicle(0,customerId,numberPlate,model));
        System.out.println("Vehicle added successfully...");
    }

    public Vehicle getVehicleByCustomerId(int customerId) throws SQLException {
       return vehicleService.getVehicleByCustomerId(customerId);
    }
}
