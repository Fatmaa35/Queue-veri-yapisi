public class Main {

    public static void main(String[] args) {
        Kuyruk k = new Kuyruk(); // Yeni kuyruk nesnesi oluşturuyoruz

        if (k.bosmu()) {
            System.out.println("Kuyruk boş!");
        }

        k.ekle(49);
        k.ekle(100);

        System.out.println("Kuyruktan çıkan: " + k.cikar());

        k.ekle(44);
        k.ekle(22);

        System.out.println("Kuyruktan çıkan: " + k.cikar());
        System.out.println("Kuyruktan çıkan: " + k.cikar());
        System.out.println("Kuyruktan çıkan: " + k.cikar());
        System.out.println("Kuyruktan çıkan: " + k.cikar());

        if (k.bosmu()) {
            System.out.println("Kuyruk boş!");
        }
    }
}

// 🔹 Kuyruk (Queue) sınıfı
class Kuyruk {
    private static final int N = 10; // Kuyruk kapasitesi
    private int[] K = new int[N];
    private int on;
    private int arka;
    private int elemanSayisi;

    // Constructor(Yapıcı) Metod (Class ismiyle aynı olduğuna dikkat edin)
    public Kuyruk() {
        on = arka = elemanSayisi = 0;
    }

    public boolean bosmu() {
        return elemanSayisi == 0;
    }

    public boolean dolumu() {
        return elemanSayisi == N;
    }

    public void ekle(int yeni) {
        if (dolumu()) {
            System.out.println("Kuyruk dolu!");
            return;
        }

        K[arka] = yeni;
        arka++;
        if (arka == N) arka = 0; // Çevrimsel Kuyruk.(Arka göstericisi son elemana geldiğinde en başa dönüp 0.index'i gösterecek ve oraya eleman ekleyecek.)
        elemanSayisi++;
    }

    public int cikar() {
        if (bosmu()) {
            System.out.println("Kuyruk boş!");
            return -1;
        }

        int veri = K[on];
        on++;
        if (on == N) on = 0;  
        elemanSayisi--;
        return veri;  // Burada eğer return'den sonra on++ deseydik on işaretçisinin index'i artmayacak dolayısıyla bir sonraki elemanı göstermeyecektir. 
                      // çünkü derleyici return'ü gördüğü anda programdan çıkar ve return'den sonra gelen hiçbir işlemi yapmaz. O yüzden buraya dikkat edilmesi gerekir!!!
    }
}
