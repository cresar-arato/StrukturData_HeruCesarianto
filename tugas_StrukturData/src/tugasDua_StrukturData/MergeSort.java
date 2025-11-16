package tugasDua_StrukturData;

import java.util.Arrays;

public class MergeSort {
	//Method utama untuk memulai proses Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return; //Array kosong atau hanya satu elemen sudah terurut
        }
        
        //Buat array bantuan (helper array)
        int[] helper = new int[arr.length];
        
        //Panggil fungsi rekursif untuk mengurutkan array
        mergeSort(arr, helper, 0, arr.length - 1);
    }

    //method rekursif untuk membagi array
    private static void mergeSort(int[] arr, int[] helper, int bawah, int atas) {
        if (bawah < atas) {
            int tengah = bawah + (atas - bawah) / 2;
            
            //Bagi array bagian kiri
            mergeSort(arr, helper, bawah, tengah);
            
            //Bagi array bagian kanan
            mergeSort(arr, helper, tengah + 1, atas);
            
            //Gabungkan (Merge) kedua bagian yang sudah terurut
            merge(arr, helper, bawah, tengah, atas);
        }
    }

    //method untuk menggabungkan dua sub-array yang sudah terurut (Descending)
    private static void merge(int[] arr, int[] helper, int bawah, int tengah, int atas) {
        //Salin kedua bagian ke array helper
        for (int i = bawah; i <= atas; i++) {
            helper[i] = arr[i];
        }

        int helperLeft = bawah;
        int helperRight = tengah + 1;
        int current = bawah;

        //Iterasi melalui array helper. Bandingkan elemen dari sub-array kiri dan kanan
        //Pindahkan elemen yang LEBIH BESAR ke array utama (arr)
        while (helperLeft <= tengah && helperRight <= atas) {
            if (helper[helperLeft] >= helper[helperRight]) {
                //Elemen dari sub-array kiri lebih besar atau sama
                arr[current] = helper[helperLeft];
                helperLeft++;
            } else {
                //Elemen dari sub-array kanan lebih besar
                arr[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        //Salin sisa elemen dari sub-array kiri (jika ada)
        //Jika sisa di kanan, biarkan saja karena sudah ada di arr[current..atas]
        int remaining = tengah - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            arr[current + i] = helper[helperLeft + i];
        }
    }

    public static void main(String[] args) {
        //Data yang digunakan: {12, 5, 18, 12, 3, 21, 1, 18}
        int[] dataAwal = {12, 5, 18, 12, 3, 21, 1, 18};
        
        System.out.println("Data Awal (Input): \n" + Arrays.toString(dataAwal));

        //Panggil metode pengurutan
        mergeSort(dataAwal);

        System.out.println("Data Setelah Diurutkan (Descending): \n" + Arrays.toString(dataAwal));
    }
}
