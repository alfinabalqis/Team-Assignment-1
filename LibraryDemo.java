import java.util.Scanner;

public class LibraryDemo {
    public static void main(String[] args) {
        // Buat instance perpustakaan
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Demo dengan data awal
        System.out.println("=== DEMO SISTEM MANAJEMEN PERPUSTAKAAN ===\n");

        // Menambahkan beberapa buku awal
        System.out.println("1. MENAMBAHKAN BUKU BARU:");
        library.addBook(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "978-0-7475-3269-9"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4"));
        library.addBook(new Book("1984", "George Orwell", "978-0-452-28423-4"));
        library.addBook(new Book("Pride and Prejudice", "Jane Austen", "978-0-14-143951-8"));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0-7432-7356-5"));

        System.out.println("\n" + "=".repeat(50));

        // Menampilkan semua buku
        System.out.println("\n2. MENAMPILKAN SEMUA BUKU:");
        library.displayAllBooks();

        System.out.println("\n" + "=".repeat(50));

        // Mencari buku berdasarkan judul
        System.out.println("\n3. MENCARI BUKU BERDASARKAN JUDUL:");
        String searchTitle = "1984";
        Book foundBook = library.findBookByTitle(searchTitle);
        if (foundBook != null) {
            System.out.println("Buku ditemukan: " + foundBook);
        } else {
            System.out.println("Buku dengan judul '" + searchTitle + "' tidak ditemukan.");
        }

        // Mencari buku yang tidak ada
        searchTitle = "The Hobbit";
        foundBook = library.findBookByTitle(searchTitle);
        if (foundBook != null) {
            System.out.println("Buku ditemukan: " + foundBook);
        } else {
            System.out.println("Buku dengan judul '" + searchTitle + "' tidak ditemukan.");
        }

        System.out.println("\n" + "=".repeat(50));

        // Mencari buku berdasarkan kata kunci
        System.out.println("\n4. MENCARI BUKU BERDASARKAN KATA KUNCI:");
        String keyword = "Harry";
        Book[] searchResults = library.searchBooksByKeyword(keyword);
        System.out.println("Hasil pencarian untuk kata kunci '" + keyword + "':");
        if (searchResults.length > 0) {
            for (Book book : searchResults) {
                System.out.println("- " + book);
            }
        } else {
            System.out.println("Tidak ada buku yang ditemukan.");
        }

        System.out.println("\n" + "=".repeat(50));

        // Menghapus buku
        System.out.println("\n5. MENGHAPUS BUKU:");
        String bookToRemove = "1984";
        library.removeBook(bookToRemove);

        // Mencoba menghapus buku yang tidak ada
        bookToRemove = "The Hobbit";
        library.removeBook(bookToRemove);

        System.out.println("\n" + "=".repeat(50));

        // Menampilkan buku setelah penghapusan
        System.out.println("\n6. DAFTAR BUKU SETELAH PENGHAPUSAN:");
        library.displayAllBooks();

        System.out.println("\n" + "=".repeat(50));

        // Mencoba menambahkan buku yang sudah ada
        System.out.println("\n7. MENCOBA MENAMBAHKAN BUKU YANG SUDAH ADA:");
        library.addBook(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "978-0-7475-3269-9"));

        System.out.println("\n" + "=".repeat(50));

        // Menu interaktif
        System.out.println("\n8. MENU INTERAKTIF:");
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("\n=== MENU PERPUSTAKAAN ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Tampilkan Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    String title = scanner.nextLine();
                    System.out.print("Masukkan nama penulis: ");
                    String author = scanner.nextLine();
                    System.out.print("Masukkan ISBN: ");
                    String isbn = scanner.nextLine();

                    Book newBook = new Book(title, author, isbn);
                    library.addBook(newBook);
                    break;

                case 2:
                    System.out.print("Masukkan judul buku yang akan dihapus: ");
                    String titleToRemove = scanner.nextLine();
                    library.removeBook(titleToRemove);
                    break;

                case 3:
                    System.out.print("Masukkan judul buku yang dicari: ");
                    String titleToSearch = scanner.nextLine();
                    Book result = library.findBookByTitle(titleToSearch);
                    if (result != null) {
                        System.out.println("Buku ditemukan: " + result);
                    } else {
                        System.out.println("Buku tidak ditemukan.");
                    }
                    break;

                case 4:
                    library.displayAllBooks();
                    break;

                case 5:
                    continueProgram = false;
                    System.out.println("Terima kasih telah menggunakan sistem perpustakaan!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-5.");
            }
        }

        scanner.close();
    }
}