package src;

import java.util.PriorityQueue;

public class CustomHeap {

	public static void main(String[] args) {
		PriorityQueue<Student> studentHeap = new PriorityQueue<>(
				(a,b) -> Integer.compare(a.grade, b.grade)
			);
			studentHeap.add(new Student("Ali", 85));
			studentHeap.add(new Student("Zeynep", 92));
			studentHeap.add(new Student("Mehmet", 78));
		
			 while (!studentHeap.isEmpty()) {
		            System.out.println(studentHeap.poll());
		        }
	}

}
