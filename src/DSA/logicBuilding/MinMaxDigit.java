package DSA.logicBuilding;


import java.util.Scanner;

public class MinMaxDigit {

    //Find the smallest and largest digit in a given number. without sorting the array.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int minDigit = 9;
        int maxDigit = 0;

        while (num > 0) {
            int digit = num % 10;   // extract last digit
            if (digit < minDigit) minDigit = digit;
            if (digit > maxDigit) maxDigit = digit;
            num = num / 10;         // remove last digit
        }

        System.out.println("Smallest digit: " + minDigit);
        System.out.println("Largest digit: " + maxDigit);
    }
}
