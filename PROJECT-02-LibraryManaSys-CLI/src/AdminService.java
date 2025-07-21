import java.util.HashMap;
import java.util.Map;

public class AdminService {
    private final Map<String,Admin> adminMap = new HashMap<>(); // username---->user
    private Admin currentAdmin = null;

    public void registerAdmin(String username,String password,String fullName,String contact){
        if (username == null || username.trim().isEmpty() ||
                password == null || password.trim().isEmpty() ||
                fullName == null || fullName.trim().isEmpty() ||
                contact == null || contact.trim().isEmpty()) {

            System.out.println("Please enter all valid admin details.");
            return;
        }

        if(adminMap.containsKey(username)){
            System.out.println("Username already exist, Please choose another..");
            return;
        }

        Admin admin = new Admin(username,password,fullName,contact);
        adminMap.put(username,admin);

        currentAdmin = admin;

        System.out.println("Admin registered successfully: " + admin.getUsername());
    }

    public void loginUser(String username,String password){
        if(!adminMap.containsKey(username)){
            System.out.println("No User Found !");
            return;
        }

        Admin admin = adminMap.get(username);

        if(!admin.getPassword().equals(password)){
            System.out.println("Incorrect Password..!");
            return;
        }

        currentAdmin = admin;

        System.out.println("Welcome: "+ currentAdmin.getFullName());
    }


    public void logoutUser(){
        if(currentAdmin!=null){
            currentAdmin = null;
        }
        System.out.println("Logged Out..!");
    }

    public Admin getCurrentUser() {
        return currentAdmin;
    }

    public boolean isLoggedIn(){
        return currentAdmin!=null;
    }
}
