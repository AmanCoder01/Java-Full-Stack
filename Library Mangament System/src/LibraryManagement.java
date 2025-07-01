import java.util.List;
import java.util.Scanner;

public class LibraryManagement {
    private final Scanner scanner = new Scanner(System.in);
    private final BookService bookService = new BookService();
    private final AdminService adminService = new AdminService();

    private void start() {
        while (true){
            System.out.println("----------------Welcome To Library Management System---------------");
            System.out.println();

            if(!adminService.isLoggedIn()){
                System.out.println("1. Register: ");
                System.out.println("2. Login: ");
                System.out.println("3. Exit: ");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice){
                    case 1 -> register();
                    case 2 -> login();
                    case 3 -> exitApp();
                    default -> System.out.println("Invalid choice..");
                }
            }else{
                showUserMenu();
            }
        }
    }

    private void register() {
        System.out.print("Enter username: ");
        String username = scanner.next();

        System.out.print("Enter password: ");
        String password = scanner.next();

        System.out.print("Enter your full name: ");
        scanner.nextLine();
        String fullName = scanner.nextLine();

        System.out.print("Enter your contact: ");
        String contact = scanner.next();

        adminService.registerAdmin(username,password,fullName,contact);
    }


    private void login() {
        System.out.print("Enter username: ");
        String username = scanner.next();

        System.out.print("Enter password: ");
        String password = scanner.next();

        adminService.loginUser(username,password);
    }

    private void exitApp() {
        System.out.println("Thank You for using our app");
        System.exit(0);
    }

    private void showUserMenu() {
        while (adminService.isLoggedIn()){
            System.out.println("-------------Library Menu------------");
            System.out.println("1. Add Book: ");
            System.out.println("2. View UnIssued Books: ");
            System.out.println("3. Search Book byy name: ");
            System.out.println("4. Issue Book: ");
            System.out.println("5. Return Book: ");
            System.out.println("6. Show Issued Book: ");
            System.out.println("7. Show user id by name: ");
            System.out.println("8. Logout: ");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1-> addBook();
                case 2-> viewAllBooks();
                case 3-> searchBook();
                case 4-> issueBook();
                case 5-> returnBook();
                case 6-> showIssuedBook();
                case 7-> showUserIdByName();
                case 8-> adminService.logoutUser();
                default -> System.out.println("Invalid choice...");
            }
        }
    }

    private void returnBook() {

    }

    private void showUserIdByName() {
        System.out.print("Enter user name: ");
        String name = scanner.next();

        if(bookService.searchUserIdByName(name) != -1){
            System.out.println(bookService.searchUserIdByName(name));
        }else{
            System.out.println("User not found..");
        }
    }

    private void addBook() {
        scanner.nextLine();
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();


        System.out.print("Enter author name: ");
        String author = scanner.nextLine();


        bookService.addBooks(title,author,false);
    }

    private void viewAllBooks() {
        List<Book> books = bookService.viewAllBooks();

        if(books == null){
            System.out.println("No Books available..");
            return;
        }

        for(Book book: books){
            System.out.println(book);
        }
    }

    private void searchBook() {
        scanner.nextLine();
        System.out.print("Enter book name: ");
        String title = scanner.nextLine();

        List<Book> books = bookService.searchBookByName(title);

        if(books ==null){
            System.out.println("Sorry ! No books found ");
            return;
        }

        for(Book book : books){
            System.out.println(book);
        }
    }

    private void issueBook() {
        System.out.print("User already registered? (yes/no) ");
        String choice = scanner.next();

        if(choice.equalsIgnoreCase("yes")){
            System.out.print("Enter book id: ");
            int bookId = scanner.nextInt();

            System.out.print("Enter user id: ");
            int userId = scanner.nextInt();

            if(bookService.isUserRegistered(userId)){
                bookService.issueBookToUser(bookId,userId);
            }else{
                System.out.println("User Not registered...");
            }
        }else{
            System.out.print("Enter user name: ");
            String name = scanner.next();

            bookService.registerUser(name);

            System.out.print("Enter book id: ");
            int bookId = scanner.nextInt();

            if(bookService.searchUserIdByName(name) != -1){
                bookService.issueBookToUser(bookId,bookService.searchUserIdByName(name));
            }else{
                System.out.println("User not found..");
            }
        }
    }

    private void showIssuedBook(){
        List<Book> books = bookService.trackIssuedBooks();

        if(books == null){
            System.out.println("Not issued books yet..");
            return;
        }

        for(Book book: books){
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        new LibraryManagement().start();
    }


}
