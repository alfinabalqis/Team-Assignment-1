import java.util.Scanner;

public abstract class User {
    private String userId;
    private String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ID: " + userId + ", Nama: " + name;
    }

    // Metode abstrak untuk menunjukkan interaksi polymorphic
    public abstract void interactWithSystem(Library library, int choice, Scanner scanner); // Menambahkan Library
                                                                                           // sebagai parameter
}