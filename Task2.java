import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Task2 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        List<Double> randomList = getRandomList(n);

        System.out.println(Arrays.toString(randomList.toArray()));
        sort(randomList);
        System.out.println(Arrays.toString(randomList.toArray()));
    }

    public static void sort(List<Double> list) {
        mergeSort(list, list.size());
    }

    private static void mergeSort(List<Double> a, int n) {
        if (n < 2) {
            return;
        }

        int mid = n / 2;

        List<Double> l = new ArrayList<>(Collections.nCopies(mid, 0.0));
        List<Double> r = new ArrayList<>(Collections.nCopies(n - mid, 0.0));

        for (int i = 0; i < mid; i++) {
            l.set(i, a.get(i));
        }
        for (int i = mid; i < n; i++) {
            r.set(i - mid, a.get(i));
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    private static void merge(List<Double> a, List<Double> l, List<Double> r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l.get(i) <= r.get(j)) {
                a.set(k++, l.get(i++));
            } else {
                a.set(k++, r.get(j++));
            }
        }
        while (i < left) {
            a.set(k++, l.get(i++));
        }
        while (j < right) {
            a.set(k++, r.get(j++));
        }
    }

    private static List<Double> getRandomList(int n) {
        return DoubleStream
                .generate(() -> new Random().nextDouble())
                .limit(n)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
