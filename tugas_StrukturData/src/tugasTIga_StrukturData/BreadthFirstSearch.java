package tugasTIga_StrukturData;
import java.util.*;

public class BreadthFirstSearch {
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
    static boolean bfs(String mulai, int target) {
    	// Queue: Menyimpan node yang akan dikunjungi (FIFO) untuk eksplorasi level demi level.
        Queue<String> queue = new ArrayDeque<>();
        
        // sdhkesini : Menyimpan node yang sudah pernah masuk Queue
        // untuk mencegah pengulangan tak terbatas dan kunjungan ganda.
        Set<String> sdhkesini = new LinkedHashSet<>();

        // Pertama, masukkan node awal ke Queue.
        // dan tandai node awal sebagai sudah dikunjungi.
        queue.add(mulai);
        sdhkesini.add(mulai);
        System.out.println("Queue awal: " + queue);

        while (!queue.isEmpty()) {
            System.out.println("\nQueue sebelum poll: " + queue);
            
            // Kedua, ambil node terdepan (paling lama berada di Queue)
            String skrng = queue.poll();
            System.out.println("Memproses node " + skrng + " (nilai = " + value.get(skrng) + ")");
            
            // Ketiga, Mengecek target
            if (value.get(skrng) == target) {
                System.out.println(">>> Target ditemukan pada node " + skrng + " <<<");
                return true;
            }
            
            // Keempat, mengecek apakah tetangga ini belum pernah dikunjungi/masuk Queue
            for (String next : adj.get(skrng)) {
                if (!sdhkesini.contains(next)) {
                	// Tandai sudah kesini
                    sdhkesini.add(next);
                    // Lalu diproses setelah semua node yang ada di Queue saat ini selesai.
                    queue.add(next);
                    System.out.println(" -> Enqueue " + next + ", queue sekarang: " + queue);
                }
            }
        }
        // Target tidak ditemukan setelah Queue kosong
        return false;
    }
    public static void main(String[] args) {
        buildGraph();
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan angka yang dicari (BFS): ");
        int n = sc.nextInt();
        sc.close();

        System.out.println("\nMulai BFS dari node a1\n");
        boolean ketemu = bfs("a1", n);

        if (!ketemu)
        	System.out.println("\n--- xxx Target tidak ditemukan. xxx ---");
    }
}
