public class Book {
    private String title;
    private String author;
    private String isbn;
    private Boolean availability;

    // Constructor
    public Book(String title, String author, String isbn, Boolean availability) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.availability = availability;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Boolean getAvailability() {
        return availability;
    }

    // Setter methods
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    // Override toString method untuk menampilkan informasi buku
    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", availability='" + (availability ? "tersedia" : "tidak tersedia") + '\'' +
                '}';
    }

    // Override equals method untuk membandingkan buku
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Book book = (Book) obj;
        return title.equals(book.title) &&
                author.equals(book.author) &&
                isbn.equals(book.isbn);
    }
}