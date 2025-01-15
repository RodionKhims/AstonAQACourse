package khims.rodion;

public class Program {
    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "asd"}
        };

        try {
            int sum = calcArraySum(arr);
            System.out.println("Sum = " + sum);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage() + ". Incorrect value " + arr[e.getRow()][e.getCol()]);
        }
    }

    private static int calcArraySum(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length > 4 || arr[0].length > 4) {
            throw new MyArraySizeException();
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                try {
                    int val = Integer.parseInt(arr[i][j]);
                    sum += val;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return sum;
    }
}
