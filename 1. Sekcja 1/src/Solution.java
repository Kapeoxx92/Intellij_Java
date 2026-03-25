/* zadanie 2
 import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();

        // Wypisanie czasu z wiodącymi zerami
        System.out.printf("%02d:%02d%n", h, m);

        // Określenie pory dnia
        if (h >= 6 && h <= 11) {
            System.out.println("morning");
        } else if (h >= 12 && h <= 17) {
            System.out.println("afternoon");
        } else if (h >= 18 && h <= 21) {
            System.out.println("evening");
        } else {
            System.out.println("night");
        }
    }
}*/

/* zadanie 4

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pin = sc.next();

        int sum = 0;
        boolean allSame = true;

        for (int i = 0; i < pin.length(); i++) {
            int digit = pin.charAt(i) - '0';
            sum += digit;

            if (pin.charAt(i) != pin.charAt(0)) {
                allSame = false;
            }
        }

        System.out.println("****");

        System.out.println("Digit sum: " + sum);

        if (allSame) {
            System.out.println("weak");
        } else if (sum < 10) {
            System.out.println("medium");
        } else if (sum <= 24) {
            System.out.println("strong");
        } else {
            System.out.println("very strong");
        }
    }
}*/

/* zadanie 5

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            if (i % a == 0 && i % b == 0) {
                System.out.println("TICK-TOCK");
            } else if (i % a == 0) {
                System.out.println("TICK");
            } else if (i % b == 0) {
                System.out.println("TOCK");
            } else {
                System.out.println(i);
            }
        }
    }
}*/

/* zadanie 6

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int lastNonZero = 0;
        boolean hasLastNonZero = false;
        int crossings = 0;

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();

            if (temp < min) min = temp;
            if (temp > max) max = temp;

            if (temp != 0) {
                if (hasLastNonZero) {
                    if ((temp > 0 && lastNonZero < 0) ||
                            (temp < 0 && lastNonZero > 0)) {
                        crossings++;
                    }
                }
                lastNonZero = temp;
                hasLastNonZero = true;
            }
        }

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Range: " + (max - min));
        System.out.println("Crossings: " + crossings);
    }
}*/

/* zadanie 7

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long current = n;

            int steps = 0;
            long max = n;

            while (current != 1) {
                if (current % 2 == 0) {
                    current /= 2;
                } else {
                    current = 3 * current + 1;
                }

                if (current > max) {
                    max = current;
                }

                steps++;
            }

            System.out.println("Steps: " + steps);
            System.out.println("Max: " + max);
        }
    }
}*/

/* zadanie 8

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lo = sc.nextInt();
        int hi = sc.nextInt();

        boolean found = false;

        for (int i = lo; i <= hi; i++) {
            int num = i;
            int sum = 0;

            // rozbijanie liczby na cyfry
            while (num > 0) {
                int digit = num % 10;
                sum += digit * digit * digit;
                num /= 10;
            }

            // specjalny przypadek dla 0 (choć w zadaniu lo >= 1)
            if (i == 0) sum = 0;

            if (sum == i) {
                System.out.println(i);
                found = true;
            }
        }

        if (!found) {
            System.out.println("none");
        }
    }
}*/

/* zadanie 9

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long original = n;

            long reversed = 0;
            int digitCount = 0;
            int sum = 0;

            while (n > 0) {
                long digit = n % 10;

                reversed = reversed * 10 + digit;
                sum += digit;
                digitCount++;

                n /= 10;
            }

            if (reversed == original) {
                System.out.println("YES " + digitCount);
            } else {
                System.out.println("NO " + digitCount + " " + sum);
            }
        }
    }
}*/

/* zadanie 10

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // smallest prime factor (spf)
        int[] spf = new int[n + 1];

        // Sito Eratostenesa
        for (int i = 2; i <= n; i++) {
            if (spf[i] == 0) { // i jest pierwsza
                for (int j = i; j <= n; j += i) {
                    if (spf[j] == 0) {
                        spf[j] = i;
                    }
                }
            }
        }

        int q = sc.nextInt();
        while (q-- > 0) {
            int x = sc.nextInt();

            if (x < 2 || x > n) {
                System.out.println("OUT OF RANGE");
            } else if (spf[x] == x) {
                System.out.println("PRIME");
            } else {
                System.out.println("COMPOSITE " + spf[x]);
            }
        }
    }
}*/

/* zadanie 11

import java.util.Scanner;

public class Solution {

    // Convert string in fromBase to decimal (long)
    static long toDecimal(String value, int fromBase) {
        long result = 0;

        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);

            int digit;
            if (c >= '0' && c <= '9') {
                digit = c - '0';
            } else {
                digit = c - 'A' + 10;
            }

            result = result * fromBase + digit;
        }

        return result;
    }

    // Convert decimal to string in toBase
    static String fromDecimal(long decimal, int toBase) {
        if (decimal == 0) return "0";

        StringBuilder sb = new StringBuilder();

        while (decimal > 0) {
            int digit = (int)(decimal % toBase);

            char c;
            if (digit < 10) {
                c = (char) ('0' + digit);
            } else {
                c = (char) ('A' + (digit - 10));
            }

            sb.append(c);
            decimal /= toBase;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String value = sc.next();
            int fromBase = sc.nextInt();
            int toBase   = sc.nextInt();

            long decimal = toDecimal(value, fromBase);
            System.out.println(fromDecimal(decimal, toBase));
        }
    }
}*/