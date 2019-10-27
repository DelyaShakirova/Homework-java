public class MergeSort {
    public static void main(String[] args) {
        int[] testArr = {3,2,1,5,4};
        mergeSort(testArr, testArr.length);
        for (int i : testArr) {
            System.out.print(i + " ");
        }
    }

    public static void mergeSort(int[] arr, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = arr[i];
        }
        mergeSort(left, mid);
        mergeSort(right, n - mid);

        merge(arr, left, right, mid, n - mid);
    }

    public static void merge(int[] arr, int[] leftArr, int[] rightArr, int left, int right) {

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left && j < right) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            }
            else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < left) {
            arr[k++] = leftArr[i++];
        }
        while (j < right) {
            arr[k++] = rightArr[j++];
        }
    }
}
