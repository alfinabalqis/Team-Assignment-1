import java.util.Scanner;

public class Admin extends User {

    public Admin(String userId, String name) {
        super(userId, name);
    }

    @Override
    public void interactWithSystem(Library library, int choice) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 1: // Tambah Buku
                System.out.print("Masukkan judul buku: ");
                String title = scanner.nextLine();
                System.out.print("Masukkan nama penulis: ");
                String author = scanner.nextLine();
                System.out.print("Masukkan ISBN: ");
                String isbn = scanner.nextLine();

                Book newBook = new Book(title, author, isbn, true);
                library.addBook(newBook);
                break;

            case 2: // Hapus Buku
                System.out.print("Masukkan judul buku yang ingin dihapus: ");
                String removeTitle = scanner.nextLine();
                library.removeBook(removeTitle);
                break;

            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

}
