public class HeapSort {
		public void sort(int[] arr) {
				int n = arr.length;

				// 1. Create Max-Heap
				for (int i = n / 2 - 1; i >= 0; i--)
						heapify(arr, n, i);

				// 2. Elemanları tek tek heap'ten çıkart.
				for (int i = n - 1; i > 0; i--) {
						// Kök ile son elemanı değiştir.
						int temp = arr[0];
						arr[0] = arr[i];
						arr[i] = temp;

						// Kalan heap'i yeniden düzenle
						heapify(arr, i, 0);
				}
		}