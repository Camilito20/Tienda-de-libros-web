import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        library.loadUsers();
        library.loadBooks();
        saved(library);

        while (true) {
            System.out.println("\n---- Library Manager ----");
            System.out.println("1. Add book");
            System.out.println("2. Register user");
            System.out.println("3. Show all books");
            System.out.println("4. Show available books");
            System.out.println("5. Lend book");
            System.out.println("6. Return book");
            System.out.println("7. Saved");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (option) {
                case 1: // Agregar libro
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();

                    Book book = new Book(title, author, true);
                    library.addBook(title, book);
                    System.out.println("Book added successfully!");
                    break;

                case 2: // Registrar usuario
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    System.out.print("Enter user id (integer): ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();

                    User user = new User(userName, userId);
                    library.addUser(userId, user);
                    System.out.println("User registered successfully!");
                    break;

                case 3: // Mostrar todos los libros
                    System.out.println("\nAll books:");
                    library.showAllBooks();
                    break;

                case 4: // Mostrar disponibles
                    System.out.println("\nAvailable books:");
                    library.showAvailabilityBooks();
                    break;

                case 5: // Prestar libro
                    System.out.print("Enter book title: ");
                    String lendTitle = scanner.nextLine();
                    System.out.print("Enter user id: ");
                    int lendUserId = scanner.nextInt();
                    scanner.nextLine();

                    library.lendBook(lendTitle, lendUserId);
                    break;

                case 6: // Devolver libro
                    System.out.print("Enter book title: ");
                    String returnTitle = scanner.nextLine();
                    System.out.print("Enter user id: ");
                    int returnUserId = scanner.nextInt();
                    scanner.nextLine();

                    library.returnBook(returnTitle, returnUserId);
                    break;


                case 8: // Salir
                    System.out.println("Exiting...");
                    scanner.close();
                    saved(library);
                    return;

                default:
                    System.out.println("Invalid option, try again.");
                    break;
            }
        }

    }

    static void saved(Library save){
        save.saveUserTXT();
        save.saveBooksTXT();
    }
}
