public class Book {
    private String title;
    private String author;
    private boolean availability = true;

    public Book(){
    }

    public Book(String title, String author){
        setTitle(title);
        setAuthor(author);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean isAvailability() {
        return availability;
    }

    @Override
    public String toString(){
        String disponible;
        if (isAvailability()){
            disponible = "availability";
        }else {
            disponible = "not availability";
        }
        return "Title: " + getTitle() + "\n"
                + "author: " + getAuthor() + "\n"
                + disponible;
    }
}
