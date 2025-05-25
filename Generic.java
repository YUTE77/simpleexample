import java.util.*;

// 1. Temel Generic Sınıf
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    @Override
    public String toString() {
        return "Box içeriği: " + value;
    }
}

// 2. Bounded Generic Sınıf
class MathBox<T extends Number> {
    private T number;

    public MathBox(T number) {
        this.number = number;
    }

    public double square() {
        return number.doubleValue() * number.doubleValue();
    }
}

// 3. Generic Metotlar ve Wildcard Örnekleri
class Utils {
    // Her türde dizi yazdıran generic metot
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // ? Wildcard: Her türlü listeyi yazdırır
    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // Bounded Wildcard: Sadece Number veya alt sınıfları için toplama
    public static void sumList(List<? extends Number> list) {
        double sum = 0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        System.out.println("Toplam: " + sum);
    }
}

// 4. Main sınıfı: Tüm örneklerin test edildiği yer
public class Generic {
    public static void main(String[] args) {
        // Box kullanımı
        Box<String> stringBox = new Box<>();
        stringBox.set("Merhaba Generics");
        System.out.println(stringBox);

        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println(intBox);

        // MathBox (bounded generic) kullanımı
        MathBox<Double> mathBox = new MathBox<>(3.0);
        System.out.println("3.0 sayısının karesi: " + mathBox.square());

        MathBox<Integer> intMath = new MathBox<>(7);
        System.out.println("7 sayısının karesi: " + intMath.square());

        // Generic metot ile dizi yazdırma
        String[] fruits = {"elma", "armut", "çilek"};
        Integer[] numbers = {1, 2, 3, 4, 5};
        System.out.print("Meyveler: ");
        Utils.printArray(fruits);
        System.out.print("Sayılar: ");
        Utils.printArray(numbers);

        // Wildcard ile liste yazdırma
        List<String> names = Arrays.asList("Ali", "Veli", "Ayşe");
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        System.out.print("İsimler listesi: ");
        Utils.printList(names);
        System.out.print("Ondalık sayı listesi: ");
        Utils.printList(doubleList);

        // Bounded wildcard ile toplam alma
        List<Integer> intList = Arrays.asList(10, 20, 30);
        Utils.sumList(intList);

        List<Float> floatList = Arrays.asList(2.5f, 3.5f);
        Utils.sumList(floatList);
    }
}
