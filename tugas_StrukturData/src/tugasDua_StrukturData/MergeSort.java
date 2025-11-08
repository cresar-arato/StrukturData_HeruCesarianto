package tugasSatu_StrukturData;

import java.util.LinkedList;

public class Tugas1_StrukturData {
	public static void main(String[] args) {
		// 1. Deklarasi variabel dengan tipe data integer yang bernama ‘StrukturBaris’
		int StrukturBaris = 0 ;
		
		// Menampilkan isi Integer StrukturBaris
		System.out.println();
		System.out.println("Integer Struktur Baris : "+StrukturBaris);
				
		
		// 2. Deklarasi variabel dengan tipe data string yang bernama ‘KataBaru’ yang berisi kata ‘Deklarasi tipe data String’
		String KataBaru = "Deklarasi tipe data String";
		
		// Menampilkan isi String
		System.out.println();
		System.out.println("String KataBaru : "+KataBaru);
		
		
		// 3.Pendeklarasian array satu dimensi dengan nama ‘empatAngka’, tipe data integer
		int[] empatAngka = {7, 10, 20, 23};
		
		// Menampilkan isi empatAngka
		System.out.println();
		System.out.println("Isi empatAngka : ");
			for (int i = 0; i < empatAngka.length; i++) {
				System.out.print(empatAngka[i] + "\t");
			}
				
	
		// 4. Pendeklarasian array dua dimensi dengan nama ‘Angka’, tipe data String
		// terdiri dari tiga baris dan tiga kolom, isi baris dan kolom berisi angka berikut :
		// (1, 3, 5, 14, 19, 20, 22, 27, 29)
		String[][] Angka = {
				{"1", "3", "5"},
				{"14", "19", "20"},
				{"22", "27", "29"}
			};
		
		// Menampilkan isi array 2 dimensi Angka
		System.out.println("\n");
		System.out.println("Isi Array 2 Dimensi Bernama 'Angka' : ");
			for (int i = 0; i < Angka.length; i++) {
				for (int j = 0; j < Angka[i].length; j++) {
					System.out.print(Angka[i][j] + "\t");
				}
				System.out.println();
			}
	
			
		// 5. Deklarasi linked list dengan nama 'listAngka' yang memiliki list (22, 19, 44, 60, 72)
		LinkedList<Integer> listAngka = new LinkedList<>();
	
		listAngka.add(22);
		listAngka.add(19);
		listAngka.add(44);
		listAngka.add(60);
		listAngka.add(72);
		
		// Menampilkan isi listAngka
		System.out.println();
		System.out.println("Isi Linked Listed dengan nama 'listAngka' : "+ "\n" + listAngka);
	}
}
