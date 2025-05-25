// Düğümleri tanımlayan sınıf
class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev; // Deque için çift yönlü bağlantı

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

// Temel tek yönlü LinkedList
class LinkedList<T> {
    protected Node<T> head;
    protected int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null)
                current = current.next;
            current.next = newNode;
        }
        size++;
    }

    public void removeFirst() {
        if (head == null) throw new RuntimeException("Liste boş.");
        head = head.next;
        size--;
    }

    public T getFirst() {
        if (head == null) throw new RuntimeException("Liste boş.");
        return head.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printList() {
        Node<T> current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null)
                System.out.print(" -> ");
            current = current.next;
        }
        System.out.println("]");
    }
}

// Stack: LIFO (Son giren, ilk çıkar)
class Stack<T> extends LinkedList<T> {
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack boş.");
        T top = head.data;
        head = head.next;
        size--;
        return top;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack boş.");
        return head.data;
    }
}

// Queue: FIFO (İlk giren, ilk çıkar)
class Queue<T> extends LinkedList<T> {
    private Node<T> tail;

    public Queue() {
        super();
        tail = null;
    }

    @Override
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void enqueue(T data) {
        addLast(data);
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue boş.");
        T val = head.data;
        head = head.next;
        size--;
        if (head == null) tail = null;
        return val;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue boş.");
        return head.data;
    }
}

// Deque: Double Ended Queue
class Deque<T> {
    private Node<T> front, rear;
    private int size;

    public Deque() {
        front = rear = null;
        size = 0;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Deque boş.");
        T val = front.data;
        front = front.next;
        if (front != null) front.prev = null;
        else rear = null;
        size--;
        return val;
    }

    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Deque boş.");
        T val = rear.data;
        rear = rear.prev;
        if (rear != null) rear.next = null;
        else front = null;
        size--;
        return val;
    }

    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Deque boş.");
        return front.data;
    }

    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Deque boş.");
        return rear.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        Node<T> current = front;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" <-> ");
            current = current.next;
        }
        System.out.println("]");
    }
}

// Ana test sınıfı
public class LinkedStructures {
    public static void main(String[] args) {
        System.out.println("Stack:");
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printList(); // 30 -> 20 -> 10
        System.out.println("Popped: " + stack.pop());
        stack.printList();

        System.out.println("\nQueue:");
        Queue<String> queue = new Queue<>();
        queue.enqueue("Ali");
        queue.enqueue("Ayşe");
        queue.enqueue("Veli");
        queue.printList(); // Ali -> Ayşe -> Veli
        System.out.println("Dequeued: " + queue.dequeue());
        queue.printList();

        System.out.println("\nDeque:");
        Deque<Character> deque = new Deque<>();
        deque.addFirst('C');
        deque.addFirst('B');
        deque.addLast('D');
        deque.addFirst('A');
        deque.printDeque(); // A <-> B <-> C <-> D
        deque.removeFirst();
        deque.removeLast();
        deque.printDeque(); // B <-> C
    }
}
