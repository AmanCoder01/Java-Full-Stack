import java.util.ArrayList;
import java.util.List;

public class BookService {
   private  List<Book> booksList = new ArrayList<>();
   private  List<User> usersList = new ArrayList<>();

   public BookService(){
       booksList.add(new Book("Java Programming", "James Gosling", false));
       booksList.add(new Book("Effective Java", "Joshua Bloch", false));
       booksList.add(new Book("Clean Code", "Robert C. Martin", false));
       booksList.add(new Book("Data Structures", "Seymour Lipschutz", false));
       booksList.add(new Book("Core Java Volume I", "Cay S. Horstmann", false));
       booksList.add(new Book("Java: The Complete Reference", "Herbert Schildt", false));
       booksList.add(new Book("Head First Java", "Kathy Sierra", false));
       booksList.add(new Book("Introduction to Algorithms", "Thomas H. Cormen", false));
       booksList.add(new Book("Design Patterns", "Erich Gamma", false));
       booksList.add(new Book("Operating System Concepts", "Abraham Silberschatz", false));

       // Repeating with slight variations / duplicates
       booksList.add(new Book("Java Programming", "James Gosling", false));
       booksList.add(new Book("Clean Architecture", "Robert C. Martin", false));
       booksList.add(new Book("Head First Design Patterns", "Eric Freeman", false));
       booksList.add(new Book("Introduction to Java", "Y. Daniel Liang", false));
       booksList.add(new Book("Java in Depth", "Deepak Kumar", false));
       booksList.add(new Book("Algorithms Unlocked", "Thomas H. Cormen", false));
       booksList.add(new Book("Clean Code", "Robert C. Martin", false));
       booksList.add(new Book("Java Programming", "James Gosling", false));
       booksList.add(new Book("Effective Java", "Joshua Bloch", false));
       booksList.add(new Book("Core Java Volume II", "Cay S. Horstmann", false));
   }

   public void addBooks(String title,String author,boolean isIssued){

       if (title == null || title.trim().isEmpty() || author == null || author.trim().isEmpty()) {
           System.out.println("Please enter valid book details...");
           return;
       }

       Book book = new Book(title,author,false);
       booksList.add(book);

       System.out.println("Book added successfully...");
   }

   public List<Book> viewAllBooks(){

       if(booksList.isEmpty()){
           System.out.println("No Books Available..");
           return null;
       }

       List<Book> res = new ArrayList<>();

       for(Book book: booksList){
           if(!book.isIssued()){
               res.add(book);
           }
       }

       return res;
   }

    public void registerUser(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Please enter a valid user name.");
            return;
        }

        User user = new User(name);
        usersList.add(user);
        System.out.println("User registered successfully: " + user);
    }

    public boolean isUserRegistered(int userId){
       for(User user: usersList){
           if(user.getUserId() == userId){
               return true;
           }
       }

       return false;
    }

    public void viewAllUsers() {
       if(usersList.isEmpty()){
           System.out.println("No user found..");
           return;
       }
        for(User user: usersList){
            System.out.println(user);
        }
    }

    public int searchUserIdByName(String name) {
        for(User user: usersList){
            if(user.getName().equalsIgnoreCase(name)){
                return user.getUserId();
            }
        }
        return -1;
    }

    public void issueBookToUser(int bookId, int userId){

       User currUser = null;

       for(User user: usersList){
           if(user.getUserId() == userId){
               currUser= user;
           }
       }

        for(Book book : booksList){
            if(book.getId() == bookId){
                if(book.isIssued()){
                    System.out.println("Book is already issued to: " + book.getIssuedTo().getName());
                    return;
                }

                book.setIssued(true);
                book.setIssuedTo(currUser);
                System.out.println("Book '" + book.getTitle() + "' issued to " + currUser.getName());
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    public void returnBook(int bookId,int userId){
        User user = null;

        for(User cuUser: usersList){
            if(cuUser.getUserId() == userId){
                user= cuUser;
            }
        }

        for(Book book: booksList){
            if(book.getId() == bookId){
                if (!book.isIssued()) {
                    System.out.println("This book is not currently issued.");
                    return;
                }

                if(book.getIssuedTo()!= null && book.getIssuedTo().getUserId() != user.getUserId()){
                    System.out.println("This book was not issued to user: " + user.getName());
                    return;
                }

                book.setIssued(false);
                book.setIssuedTo(null);
                System.out.println("Book returned successfully by " + user.getName());
                return;
            }
        }

        System.out.println("Book with ID " + bookId + " not found.");
    }

    public List<Book> trackIssuedBooks(){
       List<Book> res = new ArrayList<>();

       for(Book book : booksList){
           if(book.isIssued()){
               res.add(book);
           }
       }

       if(res.isEmpty()){
        return null;
       }

        return res;
    }

    public List<Book> searchBookByName(String title) {
        List<Book> res = new ArrayList<>();

        for (Book book : booksList) {
            if (!book.isIssued() && book.getTitle().equalsIgnoreCase(title)) {
                res.add(book);
            }
        }

        if (res.isEmpty()) {
            System.out.println("No available book found with the title: " + title);
            return null;
        }

        return res;
    }

}
