package tugasDua_StrukturData;

import java.util.Arrays;

public class CountingSortVers2 {
    
	public static int[] sort(int[] Awal) {
        if (Awal == null || Awal.length == 0) {
            return Awal;
        }
        
        //menentukan nilai maksimum (untuk menentukan range/ukuran array Hitung[])
        int maks = Awal[0];
        for (int x : Awal) {
            if (x > maks) {
                maks = x;
            }
        }
        
        //ukuran array Hitung[] adalah maksimum + 1
        int[] Hitung = new int[maks + 1]; 
        
        // array Hasil[] memiliki ukuran yang sama dengan array awal
        int[] Hasil = new int[Awal.length]; 
        
        //Hitung Frekuensi Hitung[x] akan menyimpan hitungan dari setiap integer x
        for (int nilai : Awal) {
            Hitung[nilai]++;
        }
        
        //update Hitung[] untuk menyimpan posisi akhir (Ascending)
        //setiap index akan menyimpan hasil penjumlahan dari langkah sebelumnya
        //array Hitung[] yang telah di update akan mencerminkan posisi aktual 
        //dari setiap integer ke dalam Hasil[]
        for (int i = Hitung.length -2; i >= 0; i--) {
            Hitung[i] = Hitung[i] + Hitung[i + 1];
        }
        
        //Bangun Array hasil
        for (int i = Awal.length - 1; i >= 0; i--) {
            int nilai = Awal[i];
            
            //posisi di Hasil[] adalah nilai di Hitung[nilai] dikurangi 1 (karena indeks array 0)
            int posisi = Hitung[nilai] - 1; 
            
            Hasil[posisi] = nilai;
            
            //kurangi hitungan pada array Hitung[] setelah menempatkan elemen
            Hitung[nilai]--; 
        }
        return Hasil;
    }
    
    public static void main(String[] args) {
        int inputan[] = {2, 5, 7, 3, 1, 4, 5, 9, 6, 10};
        System.out.println("Data Awal (Input): \n" + Arrays.toString(inputan));
        
        //panggil sort
        int [] Akhir = sort(inputan);
        System.out.println("Data Counting Sort (Terbesar >> Terkecil): \n" + Arrays.toString(Akhir));
    }
}
