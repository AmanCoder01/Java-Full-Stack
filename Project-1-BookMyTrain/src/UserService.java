import java.util.HashMap;
import java.util.Map;

public class UserService {
    private final Map<String,User> userMap = new HashMap<>(); // username---->user

    private User currentUser = null;

    public boolean registerUser(String username,String password,String fullName,String contact){
        if(userMap.containsKey(username)){
            System.out.println("Username already exist, Please choose another..");
            return false;
        }

        User user = new User(username,contact,password,fullName);
        userMap.put(username,user);

        currentUser = user;
        System.out.println("Registration Successful..");
        return true;
    }


    public boolean loginUser(String username,String password){
        if(!userMap.containsKey(username)){
            System.out.println("No User Found !");
            return false;
        }

        User user = userMap.get(username);

        if(!user.getPassword().equals(password)){
            System.out.println("Incorrect Password..!");
            return false;
        }

        currentUser = user;

        System.out.println("Welcome: "+ currentUser.getFullName());
        return true;
    }

    public void logoutUser(){
        if(currentUser!=null){
            currentUser = null;
        }
        System.out.println("Logged Out..!");
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn(){
        return currentUser!=null;
    }
}
