package Merge2;

import java.util.List;

public class BubbleSort<T extends Comparable<T>> {

    public void sort(List<T> list) {
        int n = list.size();
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                    // Swap elements if they are in the wrong order
                    T temp = list.get(i - 1);
                    list.set(i - 1, list.get(i));
                    list.set(i, temp);
                    swapped = true;
                }
            }
            // Optimization: The largest element is already at the end after each pass
            n--;
        } while (swapped);
    }

    public static void main(String[] args) {
        // Example usage
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        List<Integer> numbers = List.of(4, 2, 7, 1, 9, 3);
        bubbleSort.sort(numbers);
        System.out.println("Sorted Numbers: " + numbers);
    }
}
