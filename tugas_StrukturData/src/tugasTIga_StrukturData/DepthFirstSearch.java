package tugasTIga_StrukturData;

import java.util.*;

public class DepthFirstSearch {
    // Nilai pada masing-masing node
    static Map<String, Integer> value = new LinkedHashMap<>();
    // Adjacency list
    static Map<String, List<String>> adj = new LinkedHashMap<>();

    // Membangun graf
    static void buildGraph() {
        value.put("a1", 1);
        value.put("a2", 2);
        value.put("a3", 3);
        value.put("a4", 4);
        value.put("a5", 5);
        value.put("a6", 6);
        value.put("a7", 7);
        value.put("a8", 8);
        
        adj.put("a1", Arrays.asList("a2", "a3"));
        adj.put("a2", Arrays.asList("a1", "a4", "a5"));
        adj.put("a3", Arrays.asList("a1", "a6"));
        adj.put("a4", Arrays.asList("a2", "a7", "a5"));
        adj.put("a5", Arrays.asList("a2", "a4", "a8"));
        adj.put("a6", Arrays.asList("a3", "a8"));
        adj.put("a7", Arrays.asList("a4", "a8"));
        adj.put("a8", Arrays.asList("a5", "a6", "a7"));
        
    }

    // DFS rekursif
    // Set<String> sdhkesini: Melacak node yang sudah pernah dikunjungi
    // Deque<String> tumpuk: Mencatat jalur saat ini (Tumpukan panggilan fungsi implisit)
    static boolean dfs(String sekarang, int target, Set<String> sdhkesini, Deque<String> tumpuk) {
    	// Pertama, kunjungi Node Saat Ini
    	sdhkesini.add(sekarang);
        tumpuk.push(sekarang); // Menambahkan ke tumpukan rekursi

        System.out.println("Masuk node " + sekarang + " (nilai = " + value.get(sekarang) + ")");
        System.out.println("\nTumpukan saat ini: " + tumpuk);
        
        // Kedua, mengecek Target
        if (value.get(sekarang) == target) {
            System.out.println(">>> Target ditemukan pada node " + sekarang + " <<<");
            return true;
        }
        // Ketiga, Menjelajahi Tetangga
        for (String lanjut : adj.get(sekarang)) {
            if (!sdhkesini.contains(lanjut)) {
                System.out.println(" -> Menelusuri tetangga " + lanjut);
                if (dfs(lanjut, target, sdhkesini, tumpuk))
                	return true;
            } else {
                System.out.println(" -> " + lanjut + " sudah dikunjungi, lewati.");
            }
        }
        // Backtrack, jika tidak ada jalan yang ditemukan dari node ini
        System.out.println("\nBacktracking dari node " + sekarang);
        tumpuk.pop();
        return false;
    }

    public static void main(String[] args) {
        buildGraph();
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan angka yang dicari (DFS): ");
        int n = sc.nextInt();
        sc.close();
        
        
        Set<String> kesini = new LinkedHashSet<>();
        Deque<String> tumpuk = new ArrayDeque<>();

        System.out.println("\nMulai DFS dari node a1\n");
        boolean found = dfs("a1", n, kesini, tumpuk);

        if (!found)
            System.out.println("\n--- xxx Target tidak ditemukan. xxx ---");
        else
            System.out.println("Urutan node yang telah dikunjungi: " + kesini);
    }
}
