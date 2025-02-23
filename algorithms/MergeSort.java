package datastructureandalgorithms.algorithms;

public class MergeSort implements Sorter {
    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    /*
     * Example 1:
     * arr = {2, 1}, left = 0, mid = 0, right = 1
     * n1 = 1
     * n2 = 1
     * for i = 0, L = {2}
     * for j = 0, R = {1}
     * i = 0, j = 0
     * k = 0
     * 0 < 1 && 0 < 1, 2 > 1, arr = {1, 1}, i = 0, j = 1, k = 1
     * 0 < 1, arr = {1, 2}, i = 1, j = 1, k = 1
     * 1 = 1
     * 
     * Example 2:
     * arr = {3, 4, 1, 2}, left = 0, mid = 1, right = 3
     * n1 = 2
     * n2 = 2
     * for i = 0, L = {3}
     * for i = 1, L = {3, 4}
     * for j = 0, R = {1}
     * for j = 1, R = {1, 2}
     * i = 0, j = 0, k = 0
     * 
     */
    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
