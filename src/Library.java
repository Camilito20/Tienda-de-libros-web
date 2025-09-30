import java.io.*;
import java.util.HashMap;

public class Library{
    HashMap<String, Book> books = new HashMap<>();
    HashMap<Integer, User> users = new HashMap<>();

    //Agrega un libro
    public void addBook(String name, Book book){
        books.put(name, book);
    }

    //Agrega al usuario
    public void addUser(int id, User user){
        users.put(id, user);
    }

    //Presta un libro al usuario
    public void lendBook(String bookTitle, int userId){
        User user = users.get(userId);
        Book book = books.get(bookTitle);

        if(user == null){
            System.out.println("No existe");
            return;
        }
        if(book == null){
            System.out.println("El libro no existe");
            return;
        }
        if(!book.isAvailability()){
            System.out.println("El libro ya esta prestado");
            return;
        }

        book.setAvailability(false);
        user.borrowBook(book);
        System.out.println("El libro " + book.getTitle() + " fue entregado a " + user.getName());
    }

    //El usuario devuelve el libro a la libreria
    public void returnBook(String bookTitle, int userId){
        User user = users.get(userId);
        Book book = books.get(bookTitle);

        if(user == null){
            System.out.println("No existe");
            return;
        }
        if(book == null){
            System.out.println("El libro no existe");
            return;
        }
        if(book.isAvailability()){
            System.out.println("El libro no ya fue devuleto o nunca fue prestado");
            return;
        }

        book.setAvailability(true);
        user.returnBook(book);
        System.out.println("El libro " + book.getTitle() + " fue devuelto por " + user.getName());
    }

    //Muestra todos los libros
    public void showAllBooks(){
        for(Book b: books.values()){
            System.out.println(b);
        }
    }

    //Muestra libros disponibles
    public void showAvailabilityBooks(){
        for(Book b: books.values()){
            if(b.isAvailability()){
                System.out.println(b);
            }
        }
    }

    //Guardo los libros en Books.txt
    public void saveBooksTXT() {
        try(PrintWriter writer = new PrintWriter(new FileWriter("Books.txt"))){

            for(Book b: books.values()){
                writer.println(b.getTitle() + ";" + b.getAuthor() + ";" + b.isAvailability());
            }

        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Guarda a los usuarios en User.txt
    public void saveUserTXT(){
        try(PrintWriter writer = new PrintWriter(new FileWriter("Users.txt"))){

            for(User u: users.values()){
                if(u.getListLendBook() != null){
                    writer.println(u.getName() + ";" + u.getId() + ";" + u.getListLendBook());
                }
                else {
                    writer.println(u.getName() + ";" + u.getId() + ";" + "null");
                }
            }

        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void loadBooks(){
        try(BufferedReader br = new BufferedReader(new FileReader("Books.txt"))) {

            String linea;
            while ((linea = br.readLine()) != null){

                String[] parte = linea.split(";");

                String title = parte[0];
                String author = parte[1];
                boolean availability = Boolean.parseBoolean(parte[2]);

                Book book = new Book(title, author, availability);
                books.put(title, book);
            }

        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void loadUsers(){
        try(BufferedReader br = new BufferedReader(new FileReader("Users.txt"))) {

            String linea;
            while ((linea = br.readLine()) != null){

                String[] parte = linea.split(";");

                String name = parte[0];
                int id = Integer.parseInt(parte[1]);
                String titleBook = parte[2];

                User user = new User(name, id, books.get(titleBook));
                users.put(id, user);
            }

        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
