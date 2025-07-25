public class User {
    private int userId;
    private String name;

    private static int idCounter=1001;

    public User( String name) {
        this.userId = idCounter++;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        User.idCounter = idCounter;
    }

    @Override
    public String toString() {
        return "User{userId=" + userId + ", name='" + name + "'}";
    }

}
