package src;

import java.util.PriorityQueue;

public class MinHeapExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Elemanlar ekleniyor
        minHeap.add(40);
        minHeap.add(10);
        minHeap.add(30);
        minHeap.add(20);

        // Elemanlar küçükten büyüğe çıkarılır
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll()); // En küçükten başlar
        }
    }
}
