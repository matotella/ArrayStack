import java.util.Stack;
import java.util.Scanner;

public class StackJumlahBuah {
    static Stack<Stack<String>> Buah = new Stack<>();
    static Stack<String> namaBuah = new Stack<>();
    static Stack<Integer> jumlahBuah = new Stack<>();
    static Stack<Integer> hargaBuah = new Stack<>();
    static int totalbelanja = 0;

    public static void main(String[] args) {
        Scanner aril = new Scanner(System.in);

        Stack<String> buah1 = new Stack<>();
        buah1.add("apel");
        buah1.add("35000");
        Buah.add(buah1);

        Stack<String> buah2 = new Stack<>();
        buah2.add("jeruk");
        buah2.add("50000");
        Buah.add(buah2);

        Stack<String> buah3 = new Stack<>();
        buah3.add("mangga");
        buah3.add("10000");
        Buah.add(buah3);

        Stack<String> buah4 = new Stack<>();
        buah4.add("duku");
        buah4.add("15000");
        Buah.add(buah4);

        Stack<String> buah5 = new Stack<>();
        buah5.add("semangka");
        buah5.add("20000");
        Buah.add(buah5);

        int pilihan = 1;
        String inputlagi = "y";
        do {
            System.out.println("Menu: ");
            System.out.println("1. Beli Buah");
            System.out.println("2. Struk Belanja");
            System.out.println("3. Keluar");
            System.out.print("Masukan Pilihan: ");
            pilihan = aril.nextInt();
            aril.nextLine();
            if (pilihan == 3) {
                System.out.println("Anda telah keluar dari program");
                break;
            }
            switch (pilihan) {
                case 1:
                    System.out.println("Buah yang tersedia: ");
                    for (int i = 0; i < 5; i++) {
                        String nama = Buah.get(i).get(0);
                        System.out.println(i + 1 + ". " + nama);
                    }
                    System.out.print("Buah yang ingin anda beli: ");
                    int buahdipilih = aril.nextInt();
                    aril.nextLine();
                    buahdipilih -= 1;

                    if (buahdipilih >= 0 && buahdipilih < Buah.size()) {
                        System.out.print("Masukan jumlah: ");
                        int jumlah = aril.nextInt();
                        aril.nextLine();

                        String nama = Buah.get(buahdipilih).get(0);
                        int harga = Integer.parseInt(Buah.get(buahdipilih).get(1));
                        int subtotal = jumlah * harga;

                        namaBuah.add(nama);
                        jumlahBuah.add(jumlah);
                        hargaBuah.add(harga);
                        totalbelanja += subtotal;

                        System.out.println("Buah telah ditambahkan kedalam keranjang");
                    } else {
                        System.out.println("Masukan berupa angka yang tersedia");
                    }
                    break;
                case 2:
                    if (namaBuah.isEmpty()) {
                        System.out.println("Anda belum membeli apapun");
                        return;
                    }
                    System.out.println("Daftar belanja:");
                    System.out.println("-".repeat(30));
                    System.out.println("No.\tNama Buah\tJumlah\tHarga\tSubtotal");

                    for (int i = 0; i < namaBuah.size(); i++) {
                        String nama = namaBuah.get(i);
                        int jumlah = jumlahBuah.get(i);
                        int harga = hargaBuah.get(i);
                        int subtotal = jumlah * harga;

                        System.out.println((i + 1) + "\t" + nama + "\t\t" + jumlah + "\t" + harga + "\t" + subtotal);
                    }

                    System.out.println("-".repeat(30));
                    System.out.println("Total: " + totalbelanja);
                    double diskon = totalbelanja * 0.15;
                    System.out.println("Discount(15%): " + diskon);
                    double totalbayar = totalbelanja - diskon;
                    System.out.println("Total bayar: " + totalbayar);
                    break;
                default:
                    System.out.println("Masukan pilihan yang tersedia");
                    break;
            }
        } while (inputlagi.equals("y"));
        aril.close();
    }
}

