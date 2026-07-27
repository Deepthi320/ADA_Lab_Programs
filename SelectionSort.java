class SelectionSortAlgorithm {

    // Method to perform Selection Sort
    void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the minimum element with the current element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Method to display the array
    void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = {64, 25, 12, 22, 11};

        SelectionSortAlgorithm sorter = new SelectionSortAlgorithm();

        long startTime = System.currentTimeMillis();

        sorter.sort(arr);

        long endTime = System.currentTimeMillis();

        System.out.println("Sorted Array:");
        sorter.printArray(arr);

        System.out.println("\nTime Taken = " + (endTime - startTime) + " milliseconds");
    }
}
