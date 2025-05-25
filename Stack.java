import java.util.ArrayList;

// Generic Stack Sınıfı
class MyStack<T> {

    // Elemanları tutmak için bir liste kullanıyoruz (dinamik dizi gibi çalışır)
    private ArrayList<T> stack;

    // Constructor: Stack başlatılıyor
    public MyStack() {
        stack = new ArrayList<>();
    }

    // push(): Yığına eleman ekler (en üste koyar)
    public void push(T item) {
        stack.add(item); // listenin sonuna eklemek = stack'in tepesine koymak
    }

    // pop(): Yığının en üstündeki elemanı çıkarır ve döner
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack boş! Pop yapılamaz.");
        }
        return stack.remove(stack.size() - 1); // en sondaki eleman = tepe
    }

    // peek(): Yığının en üstündeki elemanı çıkarmaz, sadece gösterir
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack boş! Peek yapılamaz.");
        }
        return stack.get(stack.size() - 1);
    }

    // isEmpty(): Stack boş mu?
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // size(): Stack kaç elemanlı?
    public int size() {
        return stack.size();
    }

    // toString(): Stack içeriğini yazdırmak için
    @Override
    public String toString() {
        return "Stack içeriği: " + stack.toString();
    }
}

// Ana sınıf: Stack'i test ediyoruz
public class Stack {
    public static void main(String[] args) {
        // Integer türünden stack
        MyStack<Integer> numberStack = new MyStack<>();

        System.out.println(">>> Sayı yığını oluşturuldu.");
        numberStack.push(10);
        numberStack.push(20);
        numberStack.push(30);
        System.out.println(numberStack);  // Stack içeriği: [10, 20, 30]

        System.out.println("Peek: " + numberStack.peek()); // 30
        System.out.println("Pop: " + numberStack.pop());   // 30 çıkartılır
        System.out.println(numberStack);  // Stack içeriği: [10, 20]

        System.out.println("Boş mu? " + numberStack.isEmpty()); // false
        System.out.println("Eleman sayısı: " + numberStack.size()); // 2

        System.out.println("Pop: " + numberStack.pop()); // 20
        System.out.println("Pop: " + numberStack.pop()); // 10
        System.out.println("Boş mu? " + numberStack.isEmpty()); // true

        // String türünden stack
        MyStack<String> stringStack = new MyStack<>();
        stringStack.push("ilk");
        stringStack.push("son");

        System.out.println("String Stack: " + stringStack); // [ilk, son]
    }
}
