package datastructureandalgorithms.algorithms;

public class QuickSort implements Sorter {
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /*
     * QuickSort algorithm
     */
    private void quickSort(int[] array, int min, int max) {
        if (min < max) {
            int pivot = partition(array, min, max);
            quickSort(array, min, pivot - 1);
            quickSort(array, pivot + 1, max);
        }
    }

    /* 
     * Example 1:
     * array = {5, 3, 8, 4, 2}, min = 0, max = 4
     * int pivot = 2
     * i = min - 1 = -1
     * for j = 0, array[j] = 5 > pivot, do nothing
     * for j = 1, array[j] = 3 > pivot, do nothing
     * for j = 2, array[j] = 8 > pivot, do nothing
     * for j = 3, array[j] = 4 > pivot, do nothing
     * for j = 4, array[j] = 2 = pivot, do nothing
     * int temp = array[i + 1] = array[0] = 5
     * array[i + 1] = array[max] = 2
     * array[max] = temp = 5
     * return i + 1 = 0
     * 
     * Example 2:
     * array = {2, 5, 1, 3, 7}, min = 0, max = 4
     * int pivot = 7
     * i = -1
     * for j = 0, 2 < 7, i = 0, array = {2, 5, 1, 3, 7}
     * for j = 1, 5 < 7, i = 1, array = {2, 5, 1, 3, 7}
     * for j = 2, ... no effect
     * int temp = array[7] = 7
     * array = {2, 5, 1, 3, 7} ... no effect
     * return 4
     * 
     * Example 3:
     * array = {1, 4, 3, 9, 5}, min = 0, max = 4
     * int pivot = 5
     * i = -1
     * for j = 0, 1 < 5, i = 0, array = {1, 4, 3, 9, 5}
     * for j = 1, 4 < 5, i = 1, array = {1, 4, 3, 9, 5}
     * for j = 2, 3 < 5, i = 2, array = {1, 4, 3, 9, 5}
     * for j = 3, 9 > 5, i = 2, array = {1, 4, 3, 9, 5}
     * int temp = 9
     * array = {1, 4, 3, 5, 9}
     * 
     * Example 4:
     * array = {1, 2, 3, 9, 8, 7}, min = 0, max = 5
     * int pivot = 7
     * i = -1
     * for j = 0, 1 < 7, i = 0, array = {1, 2, 3, 9, 8, 7}
     * for j = 1, 2 < 7, i = 1, array = {1, 2, 3, 9, 8, 7}
     * for j = 2, 3 < 7, i = 2, array = {1, 2, 3, 9, 8, 7}
     * for j = 3, 9 > 7, i = 2, array = {1, 2, 3, 9, 8, 7}
     * for j = 4, 8 > 7, i = 2, array = {1, 2, 3, 9, 8, 7}
     * int temp = 7
     * array = {1, 2, 3, 7, 8, 9}
     * 
     * Example 5:
     * array = {1, 9, 2, 8, 3, 5}, min = 0, max = 5
     * pivot = 5
     * i = -1
     * for j = 0, 1 < 5, i = 0, array = {1, 9, 2, 8, 3, 5}
     * for j = 1, 9 > 5, i = 0, array = {1, 9, 2, 8, 3, 5}
     * for j = 2, 2 < 5, i = 1, array = {1, 2, 9, 8, 3, 5}
     * for j = 3, 8 > 5, i = 1, array = {1, 2, 9, 8, 3, 5}
     * for j = 4, 3 < 5, i = 2, array = {1, 2, 3, 8, 9, 5}
     * temp = 8
     * array = {1, 2, 3, 5, 9, 8}
     * 
     */
    public static int partition(int[] array, int min, int max) {
        int pivot = array[max];
        int i = min - 1;
        for (int j = min; j < max; j++) {
            /*
             * Purpose: 
             */
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        /*
         * Purpose: 
         */
        int temp = array[i + 1];
        array[i + 1] = array[max];
        array[max] = temp;
        return i + 1;
    }
}