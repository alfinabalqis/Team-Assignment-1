import java.util.Arrays;

public class Library {
    private Book[] books;
    private int currentSize;
    private static final int MAX_CAPACITY = 100;

    // Constructor
    public Library() {
        this.books = new Book[MAX_CAPACITY];
        this.currentSize = 0;
    }

    // Constructor dengan kapasitas kustom
    public Library(int capacity) {
        this.books = new Book[capacity];
        this.currentSize = 0;
    }

    /**
     * Menambahkan buku baru ke dalam perpustakaan
     * 
     * @param book Buku yang akan ditambahkan
     * @return true jika berhasil ditambahkan, false jika array penuh
     */
    public boolean addBook(Book book) {
        if (currentSize >= books.length) {
            System.out.println("Perpustakaan sudah penuh! Tidak dapat menambahkan buku baru.");
            return false;
        }

        // Cek apakah buku sudah ada
        if (findBookByTitle(book.getTitle()) != null) {
            System.out.println("Buku dengan judul '" + book.getTitle() + "' sudah ada di perpustakaan.");
            return false;
        }

        books[currentSize] = book;
        currentSize++;
        System.out.println("Buku '" + book.getTitle() + "' berhasil ditambahkan ke perpustakaan.");
        return true;
    }

    /**
     * Menghapus buku dari perpustakaan berdasarkan judul
     * 
     * @param title Judul buku yang akan dihapus
     * @return true jika berhasil dihapus, false jika buku tidak ditemukan
     */
    public boolean removeBook(String title) {
        int indexToRemove = -1;

        // Cari index buku yang akan dihapus
        for (int i = 0; i < currentSize; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove == -1) {
            System.out.println("Buku dengan judul '" + title + "' tidak ditemukan.");
            return false;
        }

        // Geser semua elemen setelah index yang dihapus ke kiri
        for (int i = indexToRemove; i < currentSize - 1; i++) {
            books[i] = books[i + 1];
        }

        // Set elemen terakhir menjadi null dan kurangi ukuran
        books[currentSize - 1] = null;
        currentSize--;

        System.out.println("Buku dengan judul '" + title + "' berhasil dihapus dari perpustakaan.");
        return true;
    }

    /**
     * Mencari buku berdasarkan judul
     * 
     * @param title Judul buku yang dicari
     * @return Book object jika ditemukan, null jika tidak ditemukan
     */
    public Book findBookByTitle(String title) {
        for (int i = 0; i < currentSize; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    /**
     * Mencari semua buku yang judulnya mengandung kata kunci tertentu
     * 
     * @param keyword Kata kunci untuk pencarian
     * @return Array berisi buku-buku yang ditemukan
     */
    public Book[] searchBooksByKeyword(String keyword) {
        Book[] foundBooks = new Book[currentSize];
        int foundCount = 0;

        for (int i = 0; i < currentSize; i++) {
            if (books[i].getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                foundBooks[foundCount] = books[i];
                foundCount++;
            }
        }

        // Buat array dengan ukuran yang tepat
        Book[] result = new Book[foundCount];
        for (int i = 0; i < foundCount; i++) {
            result[i] = foundBooks[i];
        }

        return result;
    }

    /**
     * Menampilkan semua buku dalam perpustakaan
     */
    public void displayAllBooks() {
        if (currentSize == 0) {
            System.out.println("Perpustakaan kosong.");
            return;
        }

        System.out.println("=== DAFTAR BUKU DI PERPUSTAKAAN ===");
        for (int i = 0; i < currentSize; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }
        System.out.println("Total buku: " + currentSize);
    }

    /**
     * Pinjam dan kembalikan buku berdasarkan judul
     * 
     * @param title  Judul buku yang dicari
     * @param status pinjam=false, kembalikan=true
     * @return Book object jika ditemukan, null jika tidak ditemukan
     */
    public Boolean manageBookAvailability(String title, Boolean status) {
        for (int i = 0; i < currentSize; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                if (status == false && books[i].getAvailability() == false) {
                    return false; // Buku sedang dipinjam
                } else if (status == false && books[i].getAvailability() == true) {
                    books[i].setAvailability(false);
                    return true; // Buku berhasil dipinjam
                } else {
                    books[i].setAvailability(true);
                    return true; // Buku berhasil dikembalikan
                }
            }
        }
        return null;
    }

    /**
     * Mendapatkan jumlah buku saat ini
     * 
     * @return Jumlah buku yang ada di perpustakaan
     */
    public int getCurrentSize() {
        return currentSize;
    }

    /**
     * Mendapatkan kapasitas maksimum perpustakaan
     * 
     * @return Kapasitas maksimum array
     */
    public int getMaxCapacity() {
        return books.length;
    }

    /**
     * Mengecek apakah perpustakaan kosong
     * 
     * @return true jika kosong, false jika tidak
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * Mengecek apakah perpustakaan penuh
     * 
     * @return true jika penuh, false jika tidak
     */
    public boolean isFull() {
        return currentSize >= books.length;
    }
}