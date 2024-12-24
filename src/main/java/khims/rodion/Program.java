package khims.rodion;

public class Program {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        checkBetween(5, 10);
        checkNegative(0);
        System.out.println(isNegative(-1));
        cyclePrint("AQA", 3);
        System.out.println(isLeapYear(2024));
        replaceZeroOne();
        fillArr();
        calcArray();
        initMatrix();
        System.out.println(initArr(10, 1));
    }

    private static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    private static void checkSumSign() {
        int a = 1;
        int b = 2;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    private static void printColor() {
        int value = 10;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    private static void compareNumbers() {
        int a = 1;
        int b = 2;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    private static boolean checkBetween(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    private static void checkNegative(int a) {
        if (a < 0) {
            System.out.println("Отрицательное");
        } else {
            System.out.println("Положительное");
        }
    }

    private static boolean isNegative(int a) {
        return a < 0;
    }

    private static void cyclePrint(String s, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(s);
        }
    }

    private static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && !(year % 100 == 0));
    }

    private static void replaceZeroOne() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] + 1) % 2;
        }
    }

    private static void fillArr() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
    }

    private static void calcArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] = arr[i] * 2;
        }
    }

    private static void initMatrix() {
        int size = 5;
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            arr[i][i] = 1;
            arr[i][size - i - 1] = 1;
        }
    }

    private static int[] initArr(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}
