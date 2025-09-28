import java.util.HashMap;

public class Library{
    HashMap<String, Book> books = new HashMap<>();
    HashMap<Integer, User> users = new HashMap<>();

    //Agrega un libro
    public void addBook(String name, Book book){
        books.put(name, book);
    }

    //Agrega al usuario
    public void addUser(int num, User user){
        users.put(num, user);
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

    //Muestra todos los sibros
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
}
