package tugasDua_StrukturData;

import java.util.Arrays;

public class MergeSortVers2 {
	/** Method MergeSort **/
	public static int[] mergeSort (int[] list) {
        //jika list hanya memiliki 1 elemen atau kurang, ia sudah terurut
        if (list.length <= 1) {
            return list;
        }

        // --- DIVIDE ---
        int tengah = list.length / 2;
        
        //belah bagian pertama (kiri)
        int[] bagianPertama = new int[tengah]; 
        System.arraycopy(list, 0, bagianPertama, 0, tengah); 

        //belah bagian kedua (kanan)
        int lebarBagianKedua = list.length - tengah;
        int[] bagianKedua = new int[lebarBagianKedua]; 
        System.arraycopy(list, tengah, bagianKedua, 0, lebarBagianKedua); 
        
        //panggil rekursif dan menangkap hasilnya
        int[] listKiriTerurut = mergeSort(bagianPertama); // Hasil rekursi bagian kiri
        int[] listKananTerurut = mergeSort(bagianKedua); // Hasil rekursi bagian kanan

        // --- MERGE ---
        
        //gabungkan kedua bagian yang sudah terurut dan kembalikan hasilnya
        return merge(listKiriTerurut, listKananTerurut);
    }
    
    //menggabungkan 2 list yang tersortir (Logika Descending)
    private static int[] merge(int[] bagianPertama, int[] bagianKedua) {
        int[] temporari = new int[bagianPertama.length + bagianKedua.length];
        
        int indexPertama = 0; // index sekarang di bagian pertama
        int indexKedua = 0;   // index sekarang di bagian kedua
        int indexTemporari = 0; // index sekarang di temporari
        
        // Looping elemennya (jalan O(n))
        while (indexPertama < bagianPertama.length && indexKedua < bagianKedua.length) { 
            // Perubahan Kritis: Komparasi untuk DESCENDING (pilih yang lebih BESAR)
            if(bagianPertama[indexPertama] >= bagianKedua[indexKedua]) // Gunakan >= untuk stabilitas
                temporari[indexTemporari++] = bagianPertama[indexPertama++];
            else
                temporari[indexTemporari++] = bagianKedua[indexKedua++];
        }
        
        // Salin elemen tersisa dari bagian pertama
        while (indexPertama < bagianPertama.length)
            temporari[indexTemporari++] = bagianPertama[indexPertama++];
        
        // Salin elemen tersisa dari bagian kedua
        while (indexKedua < bagianKedua.length)
            temporari[indexTemporari++] = bagianKedua[indexKedua++];
            
        return temporari;
    }
        
    //pengetesan
    public static void main(String[] args) {
        int[] list = {2, 5, 7, 3, 1, 4, 5, 9, 6, 10};
        
        System.out.println("Data Awal (Input): \n" + Arrays.toString(list));
        
        //panggil dan tangkap array hasil urutan
        int[] listTerurut = mergeSort(list); 
        
        System.out.println("Data Merge Sort (Terbesar >> Terkecil): \n" + Arrays.toString(listTerurut));
    }
}

