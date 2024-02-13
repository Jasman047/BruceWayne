package Merge;
public class compare {

    // Implementation of MergeSort
    public static void mergeSort(int[] arr, int low, int high) {
        // ... (same as before)
    }

    // Implementation of BubbleSort
    public static void bubbleSort(int[] arr) {
        // ... (same as before
    }

    public static void main(String[] args) {
        // Example array for testing
        int[] testArray = {64, 25, 12, 22, 11};

        // Copy the array for each algorithm to start with the same unsorted data
        int[] mergeSortArray = testArray.clone();
        int[] bubbleSortArray = testArray.clone();

        // Perform MergeSort and BubbleSort on separate copies of the array
        mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
        bubbleSort(bubbleSortArray);

        // Print the results
        System.out.print("Original Array: ");
        printArray(testArray);
        System.out.print("MergeSort Result: ");
        printArray(mergeSortArray);
        System.out.print("BubbleSort Result: ");
        printArray(bubbleSortArray);
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
