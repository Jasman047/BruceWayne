package Merge2; 


import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<T>> {

    public List<T> sort(List<T> list) {
        int size = list.size();

        if (size <= 1) {
            return list; // Already sorted
        }

        // Split the list into two halves
        int mid = size / 2;
        List<T> left = new ArrayList<>(list.subList(0, mid));
        List<T> right = new ArrayList<>(list.subList(mid, size));

        // Recursively sort each half
        left = sort(left);
        right = sort(right);

        // Merge the sorted halves
        return merge(left, right);
    }

    private List<T> merge(List<T> left, List<T> right) {
        List<T> merged = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;

        // Compare elements and merge
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex).compareTo(right.get(rightIndex)) <= 0) {
                merged.add(left.get(leftIndex));
                leftIndex++;
            } else {
                merged.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        // Add remaining elements from both lists
        merged.addAll(left.subList(leftIndex, left.size()));
        merged.addAll(right.subList(rightIndex, right.size()));

        return merged;
    }

    public static void main(String[] args) {
        // Example usage
        MergeSort<Integer> mergeSort = new MergeSort<>();
        List<Integer> numbers = List.of(4, 2, 7, 1, 9, 3);
        List<Integer> sortedNumbers = mergeSort.sort(numbers);
        System.out.println("Sorted Numbers: " + sortedNumbers);
    }
}
