/* zadanie 1

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        // wartość bezwzględna (uwaga na long)
        long tmp = Math.abs(N);

        // specjalny przypadek
        if (tmp == 0) {
            System.out.println("Cyfry: 1");
            System.out.println("Suma: 0");
            System.out.println("Iloczyn: 0");
            System.out.println("Maks: 0");
            System.out.println("Parzyste: 1");
            System.out.println("Nieparzyste: 0");
            return;
        }

        int digits = 0;
        int sum = 0;
        long product = 1;
        int max = 0;
        int even = 0;
        int odd = 0;

        while (tmp > 0) {
            int digit = (int)(tmp % 10);

            digits++;
            sum += digit;
            product *= digit;

            if (digit > max) max = digit;

            if (digit % 2 == 0) {
                even++;
            } else {
                odd++;
            }

            tmp /= 10;
        }

        System.out.println("Cyfry: " + digits);
        System.out.println("Suma: " + sum);
        System.out.println("Iloczyn: " + product);
        System.out.println("Maks: " + max);
        System.out.println("Parzyste: " + even);
        System.out.println("Nieparzyste: " + odd);
    }
}*/

/* zadanie 2

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // Delta jako long
        long delta = (long)b * b - 4L * a * c;

        // Wierzchołek (double)
        double xv = -b / (2.0 * a);
        double yv = -delta / (4.0 * a);

        System.out.println("Delta: " + delta);
        System.out.printf("Wierzcholek: (%.2f, %.2f)%n", xv, yv);

        if (delta < 0) {
            System.out.println("BRAK ROZWIAZANIA");
        } else if (delta == 0) {
            double x = -b / (2.0 * a);
            System.out.printf("x = %.2f%n", x);
        } else {
            double sqrtDelta = Math.sqrt(delta);

            double x1 = (-b + sqrtDelta) / (2.0 * a);
            double x2 = (-b - sqrtDelta) / (2.0 * a);

            // wypisujemy większy najpierw
            double bigger = Math.max(x1, x2);
            double smaller = Math.min(x1, x2);

            System.out.printf("x1 = %.2f%n", bigger);
            System.out.printf("x2 = %.2f%n", smaller);
        }
    }
}*/

/* zadanie 3

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long income = sc.nextLong();
        double tax;

        if (income <= 30000) {
            tax = 0.0;
        } else if (income <= 120000) {
            tax = 0.12 * income - 3600;
        } else {
            tax = 10800 + 0.32 * (income - 120000);
        }

        double monthly = tax / 12.0;
        double net = income - tax;

        System.out.printf("Podatek: %.2f PLN%n", tax);
        System.out.printf("Zaliczka miesięczna: %.2f PLN%n", monthly);
        System.out.printf("Dochód netto: %.2f PLN%n", net);
    }
}*/

/* zadanie 4

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        int B = sc.nextInt();

        // specjalny przypadek
        if (N == 0) {
            System.out.println("0");
            return;
        }

        boolean negative = N < 0;
        long tmp = Math.abs(N);

        // 1️⃣ liczba cyfr
        int digits = 0;
        long t = tmp;
        while (t > 0) {
            t /= B;
            digits++;
        }

        // 2️⃣ największy dzielnik B^(digits-1)
        long divisor = 1;
        for (int i = 1; i < digits; i++) {
            divisor *= B;
        }

        // znak minus
        if (negative) {
            System.out.print("-");
        }

        // 3️⃣ wyciąganie cyfr od lewej
        while (divisor > 0) {
            int digit = (int)(tmp / divisor);

            char c;
            if (digit < 10) {
                c = (char)('0' + digit);
            } else {
                c = (char)('A' + (digit - 10));
            }

            System.out.print(c);

            tmp %= divisor;
            divisor /= B;
        }

        System.out.println();
    }
}*/

/* zadanie 5

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int count = 0;
        int sum = 0;
        int max = -1;

        StringBuilder primes = new StringBuilder();

        for (int n = A; n <= B; n++) {
            if (n < 2) continue;

            boolean isPrime = true;

            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;
                sum += n;
                max = n;
                primes.append(n).append("\n");
            }
        }

        System.out.println("Liczba pierwszych: " + count);
        System.out.println("Suma: " + sum);

        if (count == 0) {
            System.out.println("Maks: BRAK");
        } else {
            System.out.println("Maks: " + max);
        }

        System.out.print(primes.toString());
    }
}*/

/* zadanie 6

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        long current = n;

        int length = 1; // liczymy N
        long max = n;

        int evenSteps = 0;
        int oddSteps = 0;

        while (current != 1) {
            if (current % 2 == 0) {
                current /= 2;
                evenSteps++;
            } else {
                current = 3 * current + 1;
                oddSteps++;
            }

            if (current > max) {
                max = current;
            }

            length++;
        }

        System.out.println("Dlugosc: " + length);
        System.out.println("Maks: " + max);
        System.out.println("Kroki parzyste: " + evenSteps);
        System.out.println("Kroki nieparzyste: " + oddSteps);
    }
}*/

/* zadanie 7

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();

        while (true) {
            String op = sc.next();

            if (op.equals("KONIEC")) {
                break;
            }

            switch (op) {
                case "L": {
                    int n = sc.nextInt();
                    v = v << n;
                    break;
                }
                case "R": {
                    int n = sc.nextInt();
                    v = v >> n; // arytmetyczne (z zachowaniem znaku)
                    break;
                }
                case "U": {
                    int n = sc.nextInt();
                    v = v >>> n; // logiczne (bez znaku)
                    break;
                }
                case "A": {
                    int n = sc.nextInt();
                    v = v & n;
                    break;
                }
                case "O": {
                    int n = sc.nextInt();
                    v = v | n;
                    break;
                }
                case "X": {
                    int n = sc.nextInt();
                    v = v ^ n;
                    break;
                }
                case "N": {
                    v = ~v;
                    break;
                }
            }

            System.out.println(v);
        }
    }
}*/

/* zadanie 8

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long a = 1;
        long b = 1;

        for (int i = 1; i <= N; i++) {
            long value;

            if (i == 1 || i == 2) {
                value = 1;
            } else {
                value = a + b;
                a = b;
                b = value;
            }

            // dla i=2 i wcześniejszych trzeba ustawić poprawnie a,b
            if (i == 1) {
                a = 1;
                b = 1;
            }

            String type = (value <= Integer.MAX_VALUE) ? "INT" : "LONG";

            System.out.println("F(" + i + ") = " + value + " " + type);
        }
    }
}*/

/* zadanie 9

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int correct = 0;
        int errors = 0;
        int overflows = 0;

        long orVal = 0;
        long andVal = 0;
        boolean firstValid = true;

        double sum = 0.0;

        while (true) {
            int v = sc.nextInt();

            if (v == -1) {
                break;
            }

            if (v < 0) {
                errors++;
            } else if (v > 1023) {
                overflows++;
            } else {
                // poprawny odczyt
                correct++;

                if (firstValid) {
                    andVal = v;
                    firstValid = false;
                } else {
                    andVal &= v;
                }

                orVal |= v;
                sum += v;
            }
        }

        double avg = correct > 0 ? sum / correct : 0.0;

        System.out.println("Poprawne: " + correct);
        System.out.println("Bledy: " + errors);
        System.out.println("Przepelnienia: " + overflows);
        System.out.println("OR: " + orVal);
        System.out.println("AND: " + (correct > 0 ? andVal : 0));
        System.out.printf("Srednia: %.2f%n", avg);
    }
}*/

/* zadanie 10

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int D1 = sc.nextInt();
        int D2 = sc.nextInt();
        int D3 = sc.nextInt();

        int countA = 0, countB = 0, countC = 0;
        int countAB = 0, countAC = 0, countBC = 0, countABC = 0, countNone = 0;

        for (int i = 1; i <= N; i++) {
            int mask = 0;
            if (i % D1 == 0) mask |= 1;
            if (i % D2 == 0) mask |= 2;
            if (i % D3 == 0) mask |= 4;

            // wypisywanie
            if (mask == 0) {
                System.out.println(i);
            } else {
                StringBuilder sb = new StringBuilder();
                if ((mask & 1) != 0) sb.append("A");
                if ((mask & 2) != 0) sb.append("B");
                if ((mask & 4) != 0) sb.append("C");
                System.out.println(sb.toString());
            }

            // statystyki
            switch (mask) {
                case 1: countA++; break;
                case 2: countB++; break;
                case 4: countC++; break;
                case 3: countAB++; break;   // A + B
                case 5: countAC++; break;   // A + C
                case 6: countBC++; break;   // B + C
                case 7: countABC++; break;  // A + B + C
                default: countNone++; break;
            }
        }

        System.out.println("A: " + countA);
        System.out.println("B: " + countB);
        System.out.println("C: " + countC);
        System.out.println("AB: " + countAB);
        System.out.println("AC: " + countAC);
        System.out.println("BC: " + countBC);
        System.out.println("ABC: " + countABC);
        System.out.println("Brak: " + countNone);
    }
}*/