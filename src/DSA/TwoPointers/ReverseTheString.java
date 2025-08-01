package DSA.TwoPointers;

public class ReverseTheString {
    public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i += 2 * k) {
            int start = i;
            int end = Math.min(i + k - 1, arr.length - 1);
            reverse(arr, start, end);
        }

        return new String(arr);
    }

    private static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        int k = 2;
        String result = reverseStr(str, k);
        System.out.println(result);
    }
}
