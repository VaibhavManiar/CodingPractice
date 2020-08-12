package com.practice.groupon;

public class CreateCombinations {
    private static int count = 0;
    private static void findCombinationsUtil(int[] arr, int index, int num, int reducedNum) {
        // Base condition
        if (reducedNum < 0) {
            return;
        }

        // If combination is
        // found, print it
        if (reducedNum == 0) {
            /*for (int i = 0; i < index; i++)
                System.out.print(arr[i] + " ");
            System.out.println();*/
            count++;
            return;
        }

        // Find the previous number
        // stored in arr[]. It helps
        // in maintaining increasing
        // order
        int prev = (index == 0) ? 1 : arr[index - 1];

        // note loop starts from
        // previous number i.e. at
        // array location index - 1
        for (int k = prev; k <= num; k++) {
            // next element of
            // array is k
            arr[index] = k;

            // call recursively with
            // reduced number
            findCombinationsUtil(arr, index + 1, num,
                    reducedNum - k);
        }
    }

    /**
     * Function to find out all
     * combinations of positive
     * numbers that add upto given
     * number. It uses findCombinationsUtil()
     */
    public static void findCombinations(int total, int k) {
        // array to store the combinations
        // It can contain max n elements
        int arr[] = new int[total];

        // find all combinations
        findCombinationsUtil(arr, 0, k, total);
    }

    // Driver code
    public static void main(String[] args) {
        int total = 9;
        int k = 3;
        findCombinations(total, k);
        System.out.println(count);
    }
}
