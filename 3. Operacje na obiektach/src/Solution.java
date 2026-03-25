/* zadanie 1

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();

        int[] arr = new int[length];

        // wczytywanie
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }

        // wypisywanie w odwrotnej kolejności
        for (int i = length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}
 */

/* zadanie 2


import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Boolean polindrome = false;
        String word = sc.next();
        String reversed = new StringBuilder(word).reverse().toString();


        if (word.equals(reversed)) {
            System.out.println("TAK");
        }
        else {
            System.out.println("NIE");
        }
    }
}
 */

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 1000; i++) {
            int N = sc.nextInt();
        }

    }
}