import java.util.Objects;
/**
 * Encapusulates information about a book.
 * @author Team Cobra 
 */
public class Book {
    String title;
    String author;
    String isbn;
    int publicationYear;
    // number of copies in the library
    // NOTE: This is not the number of copies available in the library
    int numberOfCopies; 

    /**
     * Constructor. Most properties (except number of copies are read only)
     */
    public Book(String title, String author, String isbn, int publicationYear, int numberOfCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.numberOfCopies = numberOfCopies;
    }

    /**
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return the ISBN for this book.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @return The publication year of this book.
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * @return The number of copies of this book.
     */
    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    /**
     * Adds the given mumber of copies of this book to the library.
     */
    public void addCopies(int numCopiesToAdd) {
        numberOfCopies += numCopiesToAdd;
    }

    /**
     * This method returns a unique hash code by creating a hash code for 
     * title then author then isbn then combining the three so that the hash
     * code used is deffinitly for the book it is supose to be for.
     * @return a hash code unique to the book in  question
     * @author Anzac Houchen
     * @author anzac.shelby@gmail.com
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, author, isbn);
    }

    @Override
    public boolean equals(Object that) {
        // TODO: Implement this method.
        // NOTE: Two books are the same only if the Title, Author, and ISBN matches
        throw new UnsupportedOperationException("Not implemented");
    }
}
