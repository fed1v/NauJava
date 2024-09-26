import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Task1 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        int[] array = getRandomArray(n);

        System.out.println(Arrays.toString(array));
        
        int max = getMaxByAbs(array);
        System.out.println(max);
    }

    private static int[] getRandomArray(int n) {
        return IntStream.generate(() -> new Random().nextInt()).limit(n).toArray();
    }

    private static int getMaxByAbs(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must be not empty");
        }

        int max = Integer.MIN_VALUE;

        for (int element : array) {
            if (Math.abs(element) > Math.abs(max)) {
                max = element;
            }
        }

        return max;
    }
}
