import java.util.Scanner;

public class Aqil16_Team1 {

 public static void tambahDataKRS(Scanner scanner, String[][] dataMahasiswa, int[] totalSKS, int jumlahData) {
    System.out.println("--- Tambah Data KRS ---");
    System.out.print("Nama Mahasiswa: ");
    dataMahasiswa[jumlahData][0] = scanner.nextLine();
    System.out.print("NIM           : ");
    dataMahasiswa[jumlahData][1] = scanner.nextLine();

    boolean lanjut = true; 
    int totalSksMahasiswa = 0;

    while (lanjut) {
        System.out.print("Kode Mata Kuliah: ");
        dataMahasiswa[jumlahData][2] = scanner.nextLine();
        System.out.print("Nama Mata Kuliah: ");
        dataMahasiswa[jumlahData][3] = scanner.nextLine();
        System.out.print("Jumlah SKS (1-3): ");
        int sks = scanner.nextInt();
        scanner.nextLine();

        if (sks < 1 || sks > 3) {
            System.out.println("Jumlah SKS per mata kuliah harus antara 1 dan 3.");
            continue;
        }

        totalSksMahasiswa += sks;
        if (totalSksMahasiswa > 24) {
            System.out.println("Total SKS mahasiswa tidak boleh lebih dari 24.");
            break;
        }

        dataMahasiswa[jumlahData][4] = Integer.toString(sks);
        totalSKS[jumlahData] = totalSksMahasiswa; 

        System.out.print("Apakah ingin menambah mata kuliah lain? (y/t): ");
        String pilih = scanner.nextLine();
        if (pilih.equalsIgnoreCase("t")) {
            lanjut = false;
            System.out.println("Total SKS yang telah diambil: " + totalSksMahasiswa);
        }
    }
    System.out.println("Data KRS berhasil ditambahkan.");
}

    public static int hitungTotalSKS(String[][] dataMahasiswa, int[] totalSKS, int jumlahData) {
        int total = 0;
        for (int i = 0; i < jumlahData; i++) {
            total += totalSKS[i];
        }
        return total;
    }

    public static void tampilkanDataKRS(Scanner scanner, String[][] dataMahasiswa, int[] totalSKS, int jumlahData) {
        System.out.println("---Analisis Data KRS---");
        System.out.print("Masukkan NIM: ");
        String nimCari = scanner.nextLine();
        boolean ditemukan = false;

        for (int i = 0; i < jumlahData; i++) {
            if (dataMahasiswa[i][1].equals(nimCari)) {
                for (int j = 0; j < 5; j++) {

                    if (j == 0) System.out.println("Nama Mahasiswa   : " + dataMahasiswa[i][j]);
                    else if (j == 1) System.out.println("NIM             : " + dataMahasiswa[i][j]);
                    else if (j == 2) System.out.println("Kode Mata Kuliah: " + dataMahasiswa[i][j]);
                    else if (j == 3) System.out.println("Nama Mata Kuliah: " + dataMahasiswa[i][j]);
                }
                System.out.println("Total SKS: " + totalSKS[i]);
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Data KRS tidak ditemukan untuk NIM: " + nimCari);
        }
    }

    public static void analisisSKS(int[] totalSKS, int jumlahData) {
        int count = 0;

        for (int i = 0; i < jumlahData; i++) {
            if (totalSKS[i] < 20) {
                count++;
            }
        }
        System.out.println("Jumlah mahasiswa yang mengambil SKS kurang dari 20: " + count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int MAX_MAHASISWA = 100;

        String[][] dataMahasiswa = new String[MAX_MAHASISWA][5];
        int[] totalSKS = new int[MAX_MAHASISWA];

        int jumlahData = 0;
        int pilihan;

        do {

            System.out.println(" === Sistem Pemantauan KRS Mahasiswa ===");
            System.out.println("1. Tambah Data KRS");
            System.out.println("2. Tampilkan Data KRS Mahasiswa");
            System.out.println("3. Analisis Data KRS");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            if (pilihan == 1) {

                tambahDataKRS(sc, dataMahasiswa, totalSKS, jumlahData);
                jumlahData++;
            } else if (pilihan == 2) {

                tampilkanDataKRS(sc, dataMahasiswa, totalSKS, jumlahData);
            } else if (pilihan == 3) {

                analisisSKS(totalSKS, jumlahData);
            } else if (pilihan == 4) {

                System.out.println("Terima kasih!");
            } else {
                System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 4);

        sc.close();
    }
}
