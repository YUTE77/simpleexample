// Her düğümde veri ve bir sonraki düğümün adresi bulunur
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

// Generic LinkedList sınıfı
class MyLinkedList<T> {
    private Node<T> head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // Listenin sonuna eleman ekler
    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode; // Liste boşsa başa eklenir
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next; // sona kadar git
            }
            current.next = newNode; // sona ekle
        }

        size++;
    }

    // Belirli bir index'e eleman ekler
    public void add(int index, T data) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Geçersiz index: " + index);

        Node<T> newNode = new Node<>(data);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }

    // Belirli bir index'teki elemanı siler
    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Geçersiz index: " + index);

        if (index == 0) {
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }

        size--;
    }

    // Belirli bir index'teki değeri döndürür
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Geçersiz index: " + index);

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    // Listedeki eleman sayısını döndürür
    public int size() {
        return size;
    }

    // Listeyi yazdırmak için kullanılır
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList: [");

        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }
}

// Test sınıfı
public class LinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> myList = new MyLinkedList<>();

        System.out.println("Eleman ekleniyor...");
        myList.add("Ahmet");
        myList.add("Zeynep");
        myList.add("Mehmet");

        System.out.println(myList);

        System.out.println("2. indexe Ali ekleniyor...");
        myList.add(2, "Ali");
        System.out.println(myList);

        System.out.println("1. indexteki eleman: " + myList.get(1));

        System.out.println("Index 0 siliniyor...");
        myList.remove(0);
        System.out.println(myList);

        System.out.println("Boyut: " + myList.size());
    }
}
