import java.util.ArrayList;

public class User {
    private String name;
    private int id;
    private ArrayList<Book> listLendBook = new ArrayList<>();


    public User(){
    }

    public User(String name, int id, Book listLendBook){
        setName(name);
        setId(id);
        borrowBook(listLendBook);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id){
        if(id <= 0){
            throw new IllegalArgumentException();
        }
        this.id = id;
    }

    public int getId(){
        return id;
    }

    //pide prestado
    public void borrowBook(Book book) {
        this.listLendBook.add(book);
    }

    //devuelve el libro
    public void returnBook(Book book) {
        this.listLendBook.remove(book);
    }

    public ArrayList<Book> getListLendBook() {
        return listLendBook;
    }
}
