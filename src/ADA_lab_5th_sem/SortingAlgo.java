package ADA_lab_5th_sem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortingAlgo {

    public static void insertionSort(int[] input) {

        for (int i = 0; i < input.length; i++) {
            int j = i - 1;
            int temp = input[i];
            while (j >= 0 && input[j] > temp) {
                input[j + 1] = input[j];
                j--;
            }
            input[j + 1] = temp;
        }
        for (int j : input) {
            System.out.print(j + " ");
        }

    }

    public static void bubbleSort(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] > input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
        for (int e : input) {
            System.out.print(e + " ");
        }
    }

    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }

        for (int j : arr) {
            System.out.print(j + " ");
        }

    }

    public static void merge(int[] array, int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[n1];
        int[] M = new int[n2];

        System.arraycopy(array, p, L, 0, n1);
        for (int j = 0; j < n2; j++)
            M[j] = array[q + 1 + j];

        int i = 0, j = 0, k = p;

        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = M[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = M[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void heapSort(int[] arr) {
        int N = arr.length;
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        for (int i = N - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int N, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < N && arr[l] > arr[largest])
            largest = l;

        if (r < N && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, N, largest);
        }
    }

    static int getMax(int[] arr, int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    public static void countRadixSort(int[] arr, int n, int exp) {
        int[] output = new int[n];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public static void radixSort(int[] arr, int n) {
        int m = getMax(arr, n);
        for (int exp = 1; m / exp > 0; exp *= 10)
            countRadixSort(arr, n, exp);
    }

    public static void countSort(int[] arr) {
        int n = arr.length;

        int[] output = new int[n];

        int[] count = new int[256];
        for (int i = 0; i < 256; ++i)
            count[i] = 0;

        for (Integer c : arr) ++count[c];

        for (int i = 1; i <= 255; ++i)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i += 1) {
                int temp = arr[i];
                int j;

                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                arr[j] = temp;
            }
        }
    }

    public static void bucketSort(float[] arr, int n) {
        if (n <= 0)
            return;

        @SuppressWarnings("unchecked")
        ArrayList<Float>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<Float>();
        }

        for (int i = 0; i < n; i++) {
            float idx = arr[i] * n;
            buckets[(int) idx].add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }


    public static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 11, 52, 65, 77, 8, 9, 10};

//        System.out.println("\nInsertion Sort : ");
//        insertionSort(arr);
//
//        System.out.println("\n\nBubble Sort : ");
//        bubbleSort(arr);
//
//        System.out.println("\n\nSelection Sort : ");
//        selectionSort(arr);
//
//        System.out.println("\n\nMerge Sort : ");
//        mergeSort(arr, 0, arr.length - 1);
//        printArray(arr);
//
//        System.out.println("\nQuick Sort : ");
//        quickSort(arr, 0, arr.length - 1);
//        printArray(arr);
//
//        System.out.println("\nHeap Sort : ");
//        heapSort(arr);
//        printArray(arr);
//
//        System.out.println("\nRadix Sort : ");
//        radixSort(arr, arr.length);
//        printArray(arr);
//
//        System.out.println("\nCount Sort : ");
//        countSort(arr);
//        printArray(arr);

        System.out.println("\nShell Sort : ");
        shellSort(arr);
        printArray(arr);

//        float[] array = {1, 2, 3, 4, 11, 52, 65, 77, 8, 9, 10};
//        System.out.println("\nBucket Sort : ");
//        bucketSort(array, array.length - 1);
//        printArray(array);

    }
}
