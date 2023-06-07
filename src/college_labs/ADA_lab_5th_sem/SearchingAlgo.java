package college_labs.ADA_lab_5th_sem;

public class SearchingAlgo {

    public static int binarySearch(int[] arr, int n) {

        if (arr[0] < arr[arr.length - 1] && (n > arr[arr.length - 1] || n < arr[0])) {
            return -1;
        }

        int startIndex = 0;
        int endIndex = arr.length - 1;
        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (arr[mid] == n) {
                return mid;
            } else if (arr[mid] > n) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        return -1;
    }

    public static int linearSearch(int[] arr, int n) {
        for (int i = 0 ; i < arr.length; i++){
            if (arr[i] == n){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 8, 9, 10};

        System.out.println(binarySearch(arr, 6));
        System.out.println(linearSearch(arr, 7));

    }

}
