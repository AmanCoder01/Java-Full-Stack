import entities.Customer;
import entities.Invoice;
import entities.Vehicle;
import services.BillingService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        BillingService billingService = new BillingService();

        while (true){
            System.out.println("\n 1. Add customer with Vehicle\n 2. Generate Invoice\n 3. Show Invoices\n 4. Show Customers\n 5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Customer name: ");
                    String name= sc.next();

                    System.out.print("Phone: ");
                    String phone =sc.next();

                    Customer customer = billingService.getCustomerByPhone(phone);

                    if(customer==null){
                        billingService.createCustomer(name,phone);
                    }else{
                        System.out.println("User already exists! ");
                    }

                    System.out.print("Enter number plate: ");
                    String numberPlate= sc.next();

                    System.out.print("Enter model: ");
                    String model= sc.next();

                    billingService.addVehicle(customer.getId(),numberPlate,model);
                    break;

                case 2:
                    System.out.print("Enter Customer phone: ");
                    String phn = sc.next();

                    Customer customer1 = billingService.getCustomerByPhone(phn);
                    if (customer1 == null) {
                        System.out.println("❌ Customer not found for phone: " + phn);
                        break;
                    }

                    Vehicle vehicle = billingService.getVehicleByCustomerId(customer1.getId());
                    System.out.println(vehicle);
                    if (vehicle == null) {
                        System.out.println("❌ Vehicle not found for customer ID: " + customer1.getId());
                        break;
                    }

                    System.out.print("Enter number of services: ");
                    int servicesCount = sc.nextInt();

                    List<Integer> serviceIds = new ArrayList<>();
                    for (int i = 0; i < servicesCount; i++) {
                        System.out.print("Enter Service Id " + (i + 1) + ": ");
                        int id = sc.nextInt();
                        serviceIds.add(id);
                    }

                    int invoiceId = billingService.createInvoice(customer1.getId(), vehicle.getId(), serviceIds);
                    billingService.getInvoiceById(invoiceId);
                    break;

                case 3:
//                    billingService.showAllInvoices();
                    break;
                case 4:
                    billingService.showAllCustomers();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}
