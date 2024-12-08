public class Driver extends DriverBase {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Print the output
        testOutput.put("Compilation succeeded", null);
        printJsonOutput();
 
        /* Test For AddBook */
        Library library = new Library();
 
        // Test: Adding a book with all the correct info.
        System.out.println("Adding book 1...");
        Book book1 = new Book("Where The Red Fern Grows", "Wilson Rawls", "780395775288", 1961, 5);  // Initially 5 copies
        library.addBook(book1);
 
        // Checking if we were able to find the book after adding it
        try {
            Book foundBook = library.findByTitleAndAuthor("Where The Red Fern Grows", "Wilson Rawls");
            System.out.println("Found book: " + foundBook.getTitle() + " by " + foundBook.getAuthor());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
 
        // Test: Find by ISBN
        try {
            Book foundBookByIsbn = library.findByISBN("780395775288");
            System.out.println("Found book by ISBN: " + foundBookByIsbn.getTitle() + " by " + foundBookByIsbn.getAuthor());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
 
        // Test: Find by Title and Author (book does not exist)
        try {
            Book notFoundBook = library.findByTitleAndAuthor("Nonexistent Book", "Nonexistent Author");
        } catch (Exception e) {
            System.out.println("Error when searching for nonexistent book: " + e.getMessage());
        }

        // Test: Find by Title and Author (book does exist)
        try {
            Book correctBookwithAuthor = library.findByTitleAndAuthor("Where The Red Fern Grows", "Wilson Rawls");
            System.out.println("Found book by Ttile: " + correctBookwithAuthor.getTitle() + " and by Author " + correctBookwithAuthor.getAuthor());
        } catch (Exception e) {
            System.out.println("Error when searching for nonexistent book: " + e.getMessage());
        }
 
        // Test: Find by ISBN (nonexistent ISBN)
        try {
            Book notFoundBookByIsbn = library.findByISBN("000000000000");
        } catch (Exception e) {
            System.out.println("Error when searching for nonexistent ISBN: " + e.getMessage());
        }

        /* This Checks the aval. copies vs the copies the library owns (what was orginally added bascially our orignal stock) */
 
        // Test: Checkout a book
        testingCheckoutBook(library, "780395775288");
 
        // Test: Check the total copies (should be 5, even after checkout)
        testingTotalCopies(library, "780395775288", 5);
 
        // Test: Check available copies after checkout (should be 4)
        testingAvailableCopies(library, "780395775288", 4);
 
        // Test: Return the book
        library.returnBook("780395775288");
 
        // Test: Check the total copies (should still be 5)
        testingTotalCopies(library, "780395775288", 5);
 
        // Test: Check available copies after return (should be 5)
        testingAvailableCopies(library, "780395775288", 5);
    }
 
    // This method tests the total number of copies owned by the library
    private static void testingTotalCopies(Library library, String isbn, int expectedTotalCopies) {
        Book book = library.getBst().get(isbn);  // Retrieve the book by ISBN
        if (book != null) {
            int totalCopies = book.getNumberOfCopies();  // Get the total number of copies (from Book class)
            if (totalCopies == expectedTotalCopies) {
                System.out.println("The library has the expected total number of copies: " + totalCopies);
            } else {
                System.out.println("Unexpected total number of copies for " + book.getTitle() + ": " + totalCopies);
            }
        } else {
            System.out.println("Book not found in the library.");
        }
    }
 
    // This method tests the available copies of a book in the library
    private static void testingAvailableCopies(Library library, String isbn, int expectedAvailableCopies) {
        int availableCopies = library.getBst().numberOfCopiesAvailable(isbn, 0);  // Get the number of available copies (from BST)
        if (availableCopies == expectedAvailableCopies) {
            System.out.println("The book has the expected number of available copies: " + availableCopies);
        } else {
            System.out.println("Unexpected available copies for " + isbn + ": " + availableCopies);
        }
    }
 
    // This method tests the checkout process for a book
    private static void testingCheckoutBook(Library library, String isbn) {
        try {
            library.checkout(isbn);  // Attempt to checkout the book
            System.out.println("Checkout successful!");
        } catch (IllegalArgumentException e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }
    }
 }
 
