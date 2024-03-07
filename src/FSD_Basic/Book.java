package FSD_Basic;

class Book {
    static int totalNoOfBooks;
    String author;
    String title;
    String isbn;
    boolean isBorrowed;

    static {
        totalNoOfBooks = 0;
    }
//    { // Object Init
//        totalNoOfBooks++;
//    }

    Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    Book(String isbn) {
        this(isbn, "Unknown", "Unknown");
    }

    static int getTotalNoOfBooks() {
        return totalNoOfBooks;
    }

    void borrowBook() {
        if(totalNoOfBooks >0){
            totalNoOfBooks--;
            System.out.println("borrowed the book successfully");
        }
        else
            System.out.println("book cant be borrowed, no collection exist");
//        if (isBorrowed) {
//            System.out.println("Book is already borrowed");
//        } else {
//            this.isBorrowed = true;
//            System.out.println("Enjoy " + this.title);
//        }
    }

    void returnBook() {
        totalNoOfBooks++;
        System.out.println("book is returned");
//        if (isBorrowed) {
//            this.isBorrowed = false;
//            System.out.println("Hope you enjoyed, Please leave a review");
//        } else {
//            System.out.println("This book is already in the library");
//        }
    }

    public static void main(String[] args) {
        Book designOfThings = new Book("1", "Design", "Author");
        Book myBook = new Book("2");
        System.out.println(Book.getTotalNoOfBooks());
        designOfThings.borrowBook();
        System.out.println(Book.getTotalNoOfBooks());
        myBook.borrowBook();
        System.out.println(Book.getTotalNoOfBooks());
        designOfThings.borrowBook();
        System.out.println(Book.getTotalNoOfBooks());
        designOfThings.returnBook();
        System.out.println(Book.getTotalNoOfBooks());
        designOfThings.returnBook();
        System.out.println(Book.getTotalNoOfBooks());
        designOfThings.borrowBook();
        System.out.println(Book.getTotalNoOfBooks());
    }
}