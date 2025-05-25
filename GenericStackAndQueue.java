import java.util.ArrayList;

// ----------------------
// Generic Stack Sınıfı
// ----------------------
class MyStack<T> {
    private ArrayList<T> stack;

    public MyStack() {
        stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(item); // sona ekle = tepeye koy
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack boş! Pop yapılamaz.");
        }
        return stack.remove(stack.size() - 1); // son eleman çıkarılır
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack boş! Peek yapılamaz.");
        }
        return stack.get(stack.size() - 1); // son elemanı göster
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    @Override
    public String toString() {
        return "Stack içeriği: " + stack.toString();
    }
}

// ----------------------
// Generic Queue Sınıfı
// ----------------------
class MyQueue<T> {
    private ArrayList<T> queue;

    public MyQueue() {
        queue = new ArrayList<>();
    }

    public void enqueue(T item) {
        queue.add(item); // sona ekle
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue boş! Dequeue yapılamaz.");
        }
        return queue.remove(0); // ilk eleman çıkarılır
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue boş! Peek yapılamaz.");
        }
        return queue.get(0); // ilk elemanı göster
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    @Override
    public String toString() {
        return "Queue içeriği: " + queue.toString();
    }
}

// ----------------------
// Ana Sınıf
// ----------------------
public class GenericStackAndQueue {
    public static void main(String[] args) {

        System.out.println(" --- STACK TESTİ ---");
        MyStack<Integer> numberStack = new MyStack<>();
        numberStack.push(1);
        numberStack.push(2);
        numberStack.push(3);
        System.out.println(numberStack);  // [1, 2, 3]
        System.out.println("Peek: " + numberStack.peek()); // 3
        System.out.println("Pop: " + numberStack.pop());   // 3 çıkar
        System.out.println(numberStack);  // [1, 2]

        System.out.println("\n --- QUEUE TESTİ ---");
        MyQueue<String> nameQueue = new MyQueue<>();
        nameQueue.enqueue("Ahmet");
        nameQueue.enqueue("Mehmet");
        nameQueue.enqueue("Zeynep");
        System.out.println(nameQueue); // [Ahmet, Mehmet, Zeynep]
        System.out.println("Peek: " + nameQueue.peek());   // Ahmet
        System.out.println("Dequeue: " + nameQueue.dequeue()); // Ahmet çıkar
        System.out.println(nameQueue); // [Mehmet, Zeynep]
    }
}
