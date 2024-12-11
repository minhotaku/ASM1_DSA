import java.util.Random;

public class SortingComparison {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Random rand = new Random();

        // Random dataset
        int[] randomData = new int[10000];
        for (int i = 0; i < 10000; i++) {
            randomData[i] = rand.nextInt(10000);
        }

        // Nearly sorted dataset
        int[] nearlySortedData = new int[10000];
        for (int i = 0; i < 10000; i++) {
            nearlySortedData[i] = i;
        }

        // Reverse sorted dataset
        int[] reverseSortedData = new int[10000];
        for (int i = 0; i < 10000; i++) {
            reverseSortedData[i] = 10000 - i;
        }

        long startTime, endTime, bubbleSortTime, quickSortTime;

        // Random dataset
        int[] arr1 = randomData.clone();
        int[] arr2 = randomData.clone();

        startTime = System.nanoTime();
        bubbleSort(arr1);
        endTime = System.nanoTime();
        bubbleSortTime = endTime - startTime;

        startTime = System.nanoTime();
        quickSort(arr2, 0, arr2.length - 1);
        endTime = System.nanoTime();
        quickSortTime = endTime - startTime;

        System.out.println("Random Data:");
        System.out.println("  Bubble Sort time: " + bubbleSortTime + " nanoseconds");
        System.out.println("  Quick Sort time: " + quickSortTime + " nanoseconds");

        // Nearly sorted dataset
        arr1 = nearlySortedData.clone();
        arr2 = nearlySortedData.clone();

        startTime = System.nanoTime();
        bubbleSort(arr1);
        endTime = System.nanoTime();
        bubbleSortTime = endTime - startTime;

        startTime = System.nanoTime();
        quickSort(arr2, 0, arr2.length - 1);
        endTime = System.nanoTime();
        quickSortTime = endTime - startTime;

        System.out.println("Nearly Sorted Data:");
        System.out.println("  Bubble Sort time: " + bubbleSortTime + " nanoseconds");
        System.out.println("  Quick Sort time: " + quickSortTime + " nanoseconds");

        // Reverse sorted dataset
        arr1 = reverseSortedData.clone();
        arr2 = reverseSortedData.clone();

        startTime = System.nanoTime();
        bubbleSort(arr1);
        endTime = System.nanoTime();
        bubbleSortTime = endTime - startTime;

        startTime = System.nanoTime();
        quickSort(arr2, 0, arr2.length - 1);
        endTime = System.nanoTime();
        quickSortTime = endTime - startTime;

        System.out.println("Reverse Sorted Data:");
        System.out.println("  Bubble Sort time: " + bubbleSortTime + " nanoseconds");
        System.out.println("  Quick Sort time: " + quickSortTime + " nanoseconds");
    }
}