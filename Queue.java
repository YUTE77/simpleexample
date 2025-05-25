import java.util.ArrayList;

// Generic Queue Sınıfı
class MyQueue<T> {

    private ArrayList<T> queue;  // Elemanları tutmak için dinamik liste

    // Constructor
    public MyQueue() {
        queue = new ArrayList<>();
    }

    // enqueue(): Kuyruğa eleman ekler (sondan eklenir)
    public void enqueue(T item) {
        queue.add(item);
    }

    // dequeue(): Kuyruğun en başındaki elemanı çıkarır
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue boş! Dequeue yapılamaz.");
        }
        return queue.remove(0); // İlk giren eleman çıkarılır
    }

    // peek(): En öndeki elemanı gösterir ama çıkarmaz
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue boş! Peek yapılamaz.");
        }
        return queue.get(0);
    }

    // isEmpty(): Kuyruk boş mu?
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // size(): Kaç eleman var?
    public int size() {
        return queue.size();
    }

    // toString(): Kuyruk içeriğini yazdırır
    @Override
    public String toString() {
        return "Queue içeriği: " + queue.toString();
    }
}

// Test sınıfı
public class Queue {
    public static void main(String[] args) {

        // Integer queue oluştur
        MyQueue<Integer> numberQueue = new MyQueue<>();

        System.out.println(">>> Sayı kuyruğu oluşturuldu.");
        numberQueue.enqueue(10);
        numberQueue.enqueue(20);
        numberQueue.enqueue(30);

        System.out.println(numberQueue); // [10, 20, 30]

        System.out.println("Peek: " + numberQueue.peek()); // 10
        System.out.println("Dequeue: " + numberQueue.dequeue()); // 10 çıkar
        System.out.println(numberQueue); // [20, 30]

        System.out.println("Boş mu? " + numberQueue.isEmpty()); // false
        System.out.println("Eleman sayısı: " + numberQueue.size()); // 2

        numberQueue.dequeue(); // 20
        numberQueue.dequeue(); // 30
        System.out.println("Boş mu? " + numberQueue.isEmpty()); // true

        // String kuyruk
        MyQueue<String> nameQueue = new MyQueue<>();
        nameQueue.enqueue("Ali");
        nameQueue.enqueue("Zeynep");

        System.out.println("İsim kuyruğu: " + nameQueue); // [Ali, Zeynep]
    }
}
