package DSA.logicBuilding;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 5};
        int N = 5;

        method1_BruteForce(arr, N);
        method2_SortAndScan(arr, N);
        method3_SumFormula(arr, N);
    }

    // ------------------------------------------------------------
    // METHOD 1: Brute Force
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    static void method1_BruteForce(int[] arr, int N) {

        for (int i = 1; i <= N; i++) {
            boolean found = false;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Missing Number (Method 1): " + i);
            }
        }
    }

    // ------------------------------------------------------------
    // METHOD 2: Sort and Scan
    // Time Complexity: O(N log N)
    // Space Complexity: O(1) [Ignoring sorting overhead]
    // ------------------------------------------------------------
    static void method2_SortAndScan(int[] arr, int N) {

        Arrays.sort(arr);

        int expected = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != expected) {
                System.out.println("Missing Number (Method 2): " + expected);
                return;
            }
            expected++;
        }
    }

    // ------------------------------------------------------------
    // METHOD 3: Mathematical Formula
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    static void method3_SumFormula(int[] arr, int N) {

        int total = N * (N + 1) / 2;

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int missing = total - sum;
        System.out.println("Missing Number (Method 3): " + missing);
    }
}
