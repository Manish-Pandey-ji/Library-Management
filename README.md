# Overview
This is a Java-based Library Management System that allows librarians to efficiently manage book records. The system provides functionality to add, view, search, update, and remove books while maintaining their availability status.

# Features
Add Books: Store new books with unique IDs, titles, authors, genres, and availability status

View All Books: Display complete catalog of all books in the library

Search Books: Find books by their ID or title (case-insensitive search)

Update Books: Modify book details including title, author, genre, and availability

Delete Books: Remove books from the library catalog

Input Validation: Ensures data integrity with comprehensive validation checks

# System Requirements
Java Development Kit (JDK) 8 or later

Basic command-line interface

# Installation
Ensure you have Java installed on your system

Download or clone the repository

Compile the Java file:


javac LibraryManagementSystem.java
# Usage
Run the program with:


java LibraryManagementSystem
The system will present a menu with the following options:


    Library Management System 
1. Add a Book
2. View All Books
3. Search for a Book
4. Update Book Details
5. Delete a Book
6. Exit
Follow the on-screen prompts to perform library operations.

# Data Validation Rules
Book ID: Must be unique

Title: Cannot be empty

Author: Cannot be empty

Availability Status: Must be either "Available" or "Checked Out"

# Code Structure
Book class: Represents individual book records with properties and getters/setters

Library class: Manages the collection of books and implements all CRUD operations

LibraryManagementSystem class: Contains the main method and user interface

# Limitations
Data is stored in memory and not persisted between sessions

Single-user system (no concurrent access handling)

Basic console interface without graphical elements

# Future Enhancements
Implement database persistence

Add patron management functionality

Include due date tracking for checked out books

Develop a graphical user interface

Add reporting features

Implement bulk import/export capabilities

# Author
Manish Pandey
