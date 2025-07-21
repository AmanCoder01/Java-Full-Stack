public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;
    private User issuedTo;


    private static int bookCounter = 4001;

    public Book(String title, String author, boolean isIssued) {
        this.id = bookCounter++;
        this.title = title;
        this.author = author;
        this.isIssued = isIssued;
        this.issuedTo = null;
    }

    public User getIssuedTo() {
        return issuedTo;
    }

    public void setIssuedTo(User issuedTo) {
        this.issuedTo = issuedTo;
    }

    public static int getBookCounter() {
        return bookCounter;
    }

    public static void setBookCounter(int bookCounter) {
        Book.bookCounter = bookCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + "', author='" + author + "', isIssued=" + isIssued + " Issued to "+issuedTo+ "}";
    }
}
