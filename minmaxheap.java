public class Heaps {

    /* =======================
       MAX HEAP IMPLEMENTATION
       ======================= */
    static class MaxHeap {
        int[] heap;
        int N;

        public MaxHeap(int capacity) {
            heap = new int[capacity + 1]; // 1-indexed
            N = 0;
        }

        private void swim(int k) {
            while (k > 1 && heap[k] > heap[k / 2]) {
                swap(k, k / 2);
                k = k / 2;
            }
        }

        private void sink(int k) {
            while (2 * k <= N) {
                int j = 2 * k;
                if (j < N && heap[j] < heap[j + 1]) {
                    j++;
                }
                if (heap[k] >= heap[j]) break;
                swap(k, j);
                k = j;
            }
        }

        public void insert(int key) {
            heap[++N] = key;
            swim(N);
        }

        public int delMax() {
            if (N == 0) return -1;
            int max = heap[1];
            swap(1, N--);
            sink(1);
            return max;
        }

        private void swap(int i, int j) {
            int tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }
    }

    /* =======================
       MIN HEAP IMPLEMENTATION
       ======================= */
    static class MinHeap {
        int[] heap;
        int N;

        public MinHeap(int capacity) {
            heap = new int[capacity + 1]; // 1-indexed
            N = 0;
        }

        private void swim(int k) {
            while (k > 1 && heap[k] < heap[k / 2]) {
                swap(k, k / 2);
                k = k / 2;
            }
        }

        private void sink(int k) {
            while (2 * k <= N) {
                int j = 2 * k;
                if (j < N && heap[j] > heap[j + 1]) {
                    j++;
                }
                if (heap[k] <= heap[j]) break;
                swap(k, j);
                k = j;
            }
        }

        public void insert(int key) {
            heap[++N] = key;
            swim(N);
        }

        public int delMin() {
            if (N == 0) return -1;
            int min = heap[1];
            swap(1, N--);
            sink(1);
            return min;
        }

        private void swap(int i, int j) {
            int tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }
    }
}
