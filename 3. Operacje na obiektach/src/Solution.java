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

/* zadanie 3
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;
        int min = 10000;
        int max = -10000;
        int oddNum = 0;
        int evenNum = 0;

        if (N >= 1 && N <= 1000) {
            for (int i = 0; i < N; i++) {
                int ai = sc.nextInt();
                if (ai >= -10000 && ai <= 10000) {
                    sum += ai;
                    if (ai > max) {
                        max = ai;
                    }
                    if (ai < min) {
                        min = ai;
                    }
                    if (ai % 2 == 0) {
                        evenNum++;
                    } else if (!(ai % 2 == 0)) {
                        oddNum++;
                    }
                }
            }
        }
        System.out.println("Suma: " + sum);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Parzyste: " + evenNum);
        System.out.println("Nieparzyste: " + oddNum);
    }
}
 */

/* zadanie 4
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        int N = sc.nextInt();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c >= 'a' && c <= 'z') {
                char encrypted = (char) ('a' + (c - 'a' + N) % 26);
                result.append(encrypted);
            } else {
                result.append(c);
            }
        }

        System.out.println(result.toString());
    }
}
 */

/* zadanie 5
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] matrix = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += matrix[i][j];
            }
            System.out.println("Wiersz " + (i + 1) + ": " + sum);
        }

        for (int j = 0; j < N; j++) {
            int sum = 0;
            for (int i = 0; i < M; i++) {
                sum += matrix[i][j];
            }
            System.out.println("Kolumna " + (j + 1) + ": " + sum);
        }
    }
}
 */

/* zadanie 6
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        String pattern = sc.nextLine();

        int count = 0;

        int first = text.indexOf(pattern);

        int last = text.lastIndexOf(pattern);

        int index = text.indexOf(pattern);
        while (index != -1) {
            count++;
            index = text.indexOf(pattern, index + 1);
        }

        System.out.println("Liczba: " + count);
        System.out.println("Pierwsze: " + first);
        System.out.println("Ostatnie: " + last);
    }
}
 */

/* zadanie 7
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sentence = sc.nextLine();

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String reversed = new StringBuilder(words[i]).reverse().toString();
            result.append(reversed);

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        System.out.println(result.toString());
    }
}
 */

/* zadanie 8
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] pascal = new int[N][];

        for (int i = 0; i < N; i++) {
            pascal[i] = new int[i + 1];

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    pascal[i][j] = 1;
                } else {
                    pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < pascal[i].length; j++) {
                System.out.print(pascal[i][j]);
                if (j < pascal[i].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
 */

/* zadanie 9
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        int digits = 0;
        int upper = 0;
        int lower = 0;
        int other = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isDigit(c)) {
                digits++;
            } else if (Character.isUpperCase(c)) {
                upper++;
            } else if (Character.isLowerCase(c)) {
                lower++;
            } else {
                other++;
            }
        }

        System.out.println("Cyfry: " + digits);
        System.out.println("Wielkie: " + upper);
        System.out.println("Male: " + lower);
        System.out.println("Inne: " + other);
    }
}
 */

/* zadanie 10
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine(); // ważne: przejście do nowej linii

        String[] names = new String[N];
        int[] scores = new int[N];

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int passed = 0;
        int failed = 0;

        // wczytywanie danych
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(":");

            names[i] = parts[0];
            scores[i] = Integer.parseInt(parts[1]);

            int s = scores[i];

            sum += s;
            if (s > max) max = s;
            if (s < min) min = s;

            if (s >= 50) passed++;
            else failed++;
        }

        // sortowanie imion (kopia!)
        String[] sortedNames = names.clone();
        Arrays.sort(sortedNames);

        // wypisanie posortowanych
        System.out.print("Posortowane: ");
        for (int i = 0; i < N; i++) {
            System.out.print(sortedNames[i]);
            if (i < N - 1) System.out.print(" ");
        }
        System.out.println();

        // statystyki
        double avg = (double) sum / N;

        System.out.println("Najwyzszy: " + max);
        System.out.println("Najnizszy: " + min);
        System.out.println("Srednia: " + String.format("%.2f", avg));
        System.out.println("Zdani: " + passed);
        System.out.println("Oblani: " + failed);

        // raport w oryginalnej kolejności
        StringBuilder report = new StringBuilder();
        report.append("Raport: ");

        for (int i = 0; i < N; i++) {
            report.append(names[i])
                    .append("(")
                    .append(scores[i])
                    .append(")");

            if (i < N - 1) {
                report.append(" ");
            }
        }

        System.out.println(report.toString());
    }
}
 */
