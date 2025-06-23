import java.util.Scanner;

public class LibraryDemo {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Data awal
        library.addBook(
                new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "978-0-7475-3269-9", true));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4", true));
        library.addBook(new Book("1984", "George Orwell", "978-0-452-28423-4", true));
        library.addBook(new Book("Pride and Prejudice", "Jane Austen", "978-0-14-143951-8", true));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0-7432-7356-5", true));

        User user = null;
        int roleChoice;

        do {
            System.out.println("\n=== SELAMAT DATANG DI SISTEM PERPUSTAKAAN ===");
            System.out.println("Silakan pilih peran Anda:");
            System.out.println("1. Admin");
            System.out.println("2. Member");
            System.out.print("Masukkan pilihan (1/2): ");

            while (!scanner.hasNextInt()) {
                System.out.println("Input tidak valid. Harus berupa angka 1 atau 2.\n");
                scanner.next(); // Buang input non-angka
                System.out.print("Masukkan pilihan (1/2): ");
            }

            roleChoice = scanner.nextInt();
            scanner.nextLine(); // buang newline

            if (roleChoice == 1) {
                user = new Admin("A001", "Admin Perpustakaan");
            } else if (roleChoice == 2) {
                user = new Member("M001", "Member Perpuastakaan");
            } else {
                System.out.println("Pilihan tidak valid. Silakan pilih 1 atau 2.");
            }

        } while (user == null);

        boolean continueProgram = true;
        while (continueProgram) {
            System.out.println("\n=== MENU UNTUK " + user.getName().toUpperCase() + " ===");

            if (user instanceof Admin) {
                System.out.println("1. Tambah Buku");
                System.out.println("2. Hapus Buku");
                System.out.println("3. Cari Buku");
                System.out.println("4. Lihat Semua Buku");
                System.out.println("5. Keluar");
            } else {
                System.out.println("1. Pinjam Buku");
                System.out.println("2. Kembalikan Buku");
                System.out.println("3. Cari Buku");
                System.out.println("4. Lihat Semua Buku");
                System.out.println("5. Keluar");
            }

            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (user instanceof Admin) {
                switch (choice) {
                    case 1:
                    case 2:
                        user.interactWithSystem(library, choice);
                        break;
                    case 3:
                        System.out.print("Masukkan judul: ");
                        String title = scanner.nextLine();
                        Book b = library.findBookByTitle(title);
                        if (b != null)
                            System.out.println("Buku '" + title + "' ditemukan." + b);
                        else
                            System.out.println("Buku '" + title + "' tidak ditemukan.");
                        break;
                    case 4:
                        library.displayAllBooks();
                        break;
                    case 5:
                        continueProgram = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } else {
                switch (choice) {
                    case 1:
                    case 2:
                        user.interactWithSystem(library, choice);
                        break;
                    case 3:
                        System.out.print("Masukkan judul: ");
                        String title = scanner.nextLine();
                        Book b = library.findBookByTitle(title);
                        if (b != null)
                            System.out.println("Buku '" + title + "' ditemukan." + b);
                        else
                            System.out.println("Buku '" + title + "' tidak ditemukan.");
                        break;
                    case 4:
                        library.displayAllBooks();
                        break;
                    case 5:
                        continueProgram = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            }
        }

        scanner.close();
        System.out.println("Terima kasih telah menggunakan sistem perpustakaan!");
    }
}