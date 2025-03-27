package Library;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Book {
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private String availability;

    public Book(String bookId, String title, String author, String genre, String availability) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availability = availability;
    }

    // Getters and Setters
    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public String getAvailability() { return availability; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setAvailability(String availability) { this.availability = availability; }

    @Override
    public String toString() {
        return String.format("ID: %s, Title: %s, Author: %s, Genre: %s, Status: %s",
                bookId, title, author, genre, availability);
    }
}

class Library {
    private Map<String, Book> books = new HashMap<>();

    public boolean addBook(Book book) {
        if (books.containsKey(book.getBookId())) {
            System.out.println("Error: Book ID already exists.");
            return false;
        }

        if (book.getTitle().isEmpty() || book.getAuthor().isEmpty()) {
            System.out.println("Error: Title and Author cannot be empty.");
            return false;
        }

        if (!book.getAvailability().equals("Available") && !book.getAvailability().equals("Checked Out")) {
            System.out.println("Error: Availability must be 'Available' or 'Checked Out'.");
            return false;
        }

        books.put(book.getBookId(), book);
        System.out.println("Book added successfully!");
        return true;
    }

    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        System.out.println("\n--- All Books ---");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public void searchBook(String searchTerm) {
        boolean found = false;

        // Search by ID
        if (books.containsKey(searchTerm)) {
            System.out.println("\n--- Search Results ---");
            System.out.println(books.get(searchTerm));
            found = true;
        }

        // Search by title (case insensitive)
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                if (!found) {
                    System.out.println("\n--- Search Results ---");
                    found = true;
                }
                System.out.println(book);
            }
        }

        if (!found) {
            System.out.println("No books found matching the search term.");
        }
    }

    public boolean updateBook(String bookId, String title, String author, String genre, String availability) {
        if (!books.containsKey(bookId)) {
            System.out.println("Error: Book ID not found.");
            return false;
        }

        Book book = books.get(bookId);

        if (!title.isEmpty()) {
            book.setTitle(title);
        }
        if (!author.isEmpty()) {
            book.setAuthor(author);
        }
        if (!genre.isEmpty()) {
            book.setGenre(genre);
        }
        if (!availability.isEmpty()) {
            if (!availability.equals("Available") && !availability.equals("Checked Out")) {
                System.out.println("Error: Availability must be 'Available' or 'Checked Out'.");
                return false;
            }
            book.setAvailability(availability);
        }

        System.out.println("Book updated successfully!");
        return true;
    }

    public boolean deleteBook(String bookId) {
        if (!books.containsKey(bookId)) {
            System.out.println("Error: Book ID not found.");
            return false;
        }

        books.remove(bookId);
        System.out.println("Book deleted successfully!");
        return true;
    }
}

public class Management {
    private static Scanner scanner = new Scanner(System.in);
    private static Library library = new Library();

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addBook();
                    break;
                case "2":
                    library.viewAllBooks();
                    break;
                case "3":
                    searchBook();
                    break;
                case "4":
                    updateBook();
                    break;
                case "5":
                    deleteBook();
                    break;
                case "6":
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== Library Management System ===");
        System.out.println("1. Add a Book");
        System.out.println("2. View All Books");
        System.out.println("3. Search for a Book");
        System.out.println("4. Update Book Details");
        System.out.println("5. Delete a Book");
        System.out.println("6. Exit");
        System.out.print("Enter your choice (1-6): ");
    }

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();

        System.out.print("Enter Title: ");
        String title = scanner.nextLine().trim();

        System.out.print("Enter Author: ");
        String author = scanner.nextLine().trim();

        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine().trim();

        System.out.print("Enter Availability (Available/Checked Out): ");
        String availability = scanner.nextLine().trim();

        Book book = new Book(bookId, title, author, genre, availability);
        library.addBook(book);
    }

    private static void searchBook() {
        System.out.print("Enter Book ID or Title to search: ");
        String searchTerm = scanner.nextLine();
        library.searchBook(searchTerm);
    }

    private static void updateBook() {
        System.out.print("Enter Book ID to update: ");
        String bookId = scanner.nextLine();

        System.out.println("\nLeave blank for fields you don't want to change:");
        System.out.print("New Title: ");
        String title = scanner.nextLine().trim();

        System.out.print("New Author: ");
        String author = scanner.nextLine().trim();

        System.out.print("New Genre: ");
        String genre = scanner.nextLine().trim();

        System.out.print("New Availability (Available/Checked Out): ");
        String availability = scanner.nextLine().trim();

        library.updateBook(bookId, title, author, genre, availability);
    }

    private static void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        String bookId = scanner.nextLine();
        library.deleteBook(bookId);
    }
}