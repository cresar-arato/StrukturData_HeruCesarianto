package tugasDua_StrukturData;

import java.util.Arrays;

public class CountingSort {
	//Method untuk mengurutkan array menggunakan Counting Sort dari terbesar hingga terkecil
    public static int[] countingSortBesarKecil(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        //Tentukan nilai maksimum dan minimum (range)
        int min = arr[0];
        int maks = arr[0];
        for (int x : arr) {
            if (x < min) {
                min = x;
            }
            if (x > maks) {
                maks = x;
            }
        }

        //Hitung range (k)
        int range = maks - min + 1;

        //Inisialisasi array hitungan (count array)
        //Ukuran array hitungan adalah range
        int[] count = new int[range];

        //Hitung frekuensi setiap elemen
        //count[i] akan menyimpan jumlah kemunculan nilai (i + min)
        for (int x : arr) {
            count[x - min]++;
        }

        //Modifikasi array hitungan untuk menyimpan posisi awal
        //(Index terakhir) setiap elemen pada output array
        //Akumulasi dari belakang memastikan elemen dengan nilai lebih besar
        //memiliki posisi indeks yang lebih kecil pada output
        for (int i = range - 2; i >= 0; i--) {
            count[i] += count[i + 1];
        }

        //Bangun array output
        int[] output = new int[arr.length];

        //Iterasi array input dari belakang untuk menjaga stabilitas
        for (int i = arr.length - 1; i >= 0; i--) {
            int elementValue = arr[i];
            int countIndex = elementValue - min;
            
            //count[countIndex] saat ini menyimpan indeks di 'output' 
            //tempat elemen ini harus ditempatkan
            output[count[countIndex] - 1] = elementValue;
            
            // Kurangi hitungan untuk elemen ini (pindah ke posisi berikutnya 
            // yang lebih kecil untuk kemunculan berikutnya)
            count[countIndex]--;
        }
        return output;
    }

    public static void main(String[] args) {
        // Data yang ditentukan (minimal 8 elemen)
        // a1=12, a2=5, a3=18, a4=12, a5=3, a6=21, a7=1, a8=18
        int[] dataAwal = {12, 5, 18, 12, 3, 21, 1, 18}; 
        
        System.out.println("Data Awal (Input): \n" + Arrays.toString(dataAwal));

        // Panggil metode pengurutan
        int[] dataUrut = countingSortBesarKecil(dataAwal);

        System.out.println("Data Setelah Diurutkan (Besar >> Kecil): \n" + Arrays.toString(dataUrut));
    }
}
