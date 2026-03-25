/*import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int minute = sc.nextInt();

        System.out.printf("%02d:%02d%n", hour, minute);

        if(hour >= 6 && hour < 12) {
            System.out.println("morning");
        }
        else if(hour >= 12 && hour < 18) {
            System.out.println("afternoon");
        }
        else if (hour >= 18 && hour < 22) {
            System.out.println("evening");
        } else {
            System.out.println("night");
        }
    }
}*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []tempArr = new int[n];
        int maxTemp = 0;
        int minTemp = 10000;
        int range;
        double avgTemp = 0;
        int crossing = 0;
        int lastNotZero;

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            tempArr[i] = temp;
        }
        for (int i = 0; i < n; i++) {
            if(tempArr[i] > maxTemp) {
                maxTemp = tempArr[i];
            }
            if(tempArr[i] < minTemp) {
                minTemp = tempArr[i];
            }
            avgTemp += tempArr[i];
        }

        lastNotZero = tempArr[0];
        for (int i = 1; i < n; i++) {
            if(tempArr[i] * lastNotZero < 0 && tempArr[i] != 0) {
                crossing++;
            }
            if(tempArr[i] != 0) {
                lastNotZero = tempArr[i];
            }
        }
        range = maxTemp - minTemp;
        avgTemp = avgTemp / n;
        System.out.printf("%d %d %d %.2f %d", minTemp, maxTemp, range, avgTemp, crossing);
    }
}