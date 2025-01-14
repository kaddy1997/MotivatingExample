
import java.util.Arrays;

public class AlgorithmComparison {
    public static void main(String args[]) {

        int size = 6000;
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }

        System.out.println("Array length = " + size);
        System.out.println("\nElements randomly distributed : ");
        System.out.println("\nSorting Algorithm\tTime Taken(ns)");
        compareSortingAlgorithms(arr);

        System.out.println("\nElements already sorted : ");
        System.out.println("\nSorting Algorithm\tTime Taken(ns)");
        Arrays.sort(arr);
        compareSortingAlgorithms(arr);

        System.out.println("\nElements sorted in reverse order : ");
        System.out.println("\nSorting Algorithm\tTime Taken(ns)");
        for (int i = 0; i <= arr.length / 2; i++) {
            int t = arr[i];
            arr[i] = arr[size - i - 1];
            arr[size - i - 1] = t;
        }
        compareSortingAlgorithms(arr);
    }

    private static void compareSortingAlgorithms(int arr[]) {

        printSortingTime(SortType.BUBBLE, arr);
        printSortingTime(SortType.HEAP, arr);
        printSortingTime(SortType.MERGE, arr);
        printSortingTime(SortType.QUICK, arr);

    }

    private static void printSortingTime(SortType sortType, int[] arr) {

        int arr2[] = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);

        long startTime = System.nanoTime();

        switch (sortType) {
            case BUBBLE:
                BubbleSort.bubbleSort(arr2);
                break;
            case HEAP:
                HeapSort.heapSort(arr2);
                break;
            case MERGE:
                MergeSort.mergeSort(arr2, 0, arr2.length - 1);
                break;
            case QUICK:
                QuickSort.quickSort(arr2, 0, arr2.length - 1);
                break;
            case RADIX:
                Radix.radixSort(arr2, 0, arr2.length - 1);
                break;
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.printf("%-17s %15d %n", sortType + "_SORT", duration);
    }
}
