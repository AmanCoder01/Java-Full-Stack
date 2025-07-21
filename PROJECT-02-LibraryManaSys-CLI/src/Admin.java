public class Admin {
    private int id;
    private String username;
    private String password;
    private String fullName;
    private String contact;

    private static int counter = 200001;

    public Admin( String username, String password, String fullName, String contact) {
        this.id = counter++;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Admin.counter = counter;
    }
}
