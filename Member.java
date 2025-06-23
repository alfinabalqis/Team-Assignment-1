import java.util.Scanner;
public class Member extends User {

    public Member(String userId, String name) {
        super(userId, name);
    }

    @Override
    public void interactWithSystem(Library library, int choice) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 1: // Pinjam Buku
                System.out.print("Masukkan judul buku yang ingin dipinjam: ");
                String borrowTitle = scanner.nextLine();
                Boolean borrowResult = library.manageBookAvailability(borrowTitle, false);
                if (borrowResult == null) {
                    System.out.println("Buku '" + borrowTitle + "' tidak ditemukan.");
                } else if (!borrowResult) {
                    System.out.println("Buku '" + borrowTitle + "' sedang dipinjam.");
                } else {
                    System.out.println("Buku '" + borrowTitle + "' berhasil dipinjam.");
                }
                break;

            case 2: // Kembalikan Buku
                System.out.print("Masukkan judul buku yang ingin dikembalikan: ");
                String returnTitle = scanner.nextLine();
                Boolean returnResult = library.manageBookAvailability(returnTitle, true);
                if (returnResult == null) {
                    System.out.println("Buku '" + returnTitle + "' tidak ditemukan.");
                } else {
                    System.out.println("Buku '" + returnTitle + "' berhasil dikembalikan.");
                }
                break;

            default:
                System.out.println("Pilihan tidak valid untuk anggota.");
        }
    }
}
