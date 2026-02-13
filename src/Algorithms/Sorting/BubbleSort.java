package Algorithms.Sorting;

/**
 * Bubble Sort implementation in Java (Snippet from https://www.programiz.com/dsa/bubble-sort)
 * Algorithm:
 *  First Iteration:
 *      1. Starting from the first index, compare the first and the second elements.
 *      2. If the first element is greater than the second element, they are swapped.
 *      3. Now, compare the second and the third elements. Swap them if they are not in order.
 *      4. The above process goes on until the last element.
 *      5. After the first iteration, the largest element is stored at the last index.
 *  Remaining Iteration:
 *      1. The same process is repeated for the remaining elements. After the second iteration, the second largest element is stored at the second last index.
 *      2. This process goes on until the entire array is sorted.
 *  Time Complexity:
 *      - O(n^2) worst case,
 *      - O(n^2) average case,
 *      - O(n) in best case (when the array is already sorted)
 *  Auxiliary Space: O(1)
 *  Stability: Yes
 *  In-place: Yes
 */

import java.util.Arrays;

class BubbleSort {

    // perform the bubble sort
    static void bubbleSort(int array[]) {
        int size = array.length;

        // loop to access each array element
        for (int i = 0; i < size - 1; i++)

            // loop to compare array elements
            for (int j = 0; j < size - i - 1; j++)

                // compare two adjacent elements
                // change > to < to sort in descending order
                if (array[j] > array[j + 1]) {

                    // swapping occurs if elements
                    // are not in the intended order
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }

    public static void main(String args[]) {

        int[] data = { -2, 45, 0, 11, -9 };

        // call method using class name
        BubbleSort.bubbleSort(data);

        System.out.println("Sorted Array in Ascending Order:");
        System.out.println(Arrays.toString(data));
    }
}