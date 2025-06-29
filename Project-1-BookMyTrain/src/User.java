public class User {
    private String contact;
    private String username;
    private String password;
    private String fullName;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public User(String username, String contact, String password, String fullName) {
        this.username = username;
        this.contact = contact;
        this.password = password;
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return fullName+" ("+username +") ";
    }
}
