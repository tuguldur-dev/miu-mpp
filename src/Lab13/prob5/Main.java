package Lab13.prob5;

import java.util.List;

public class Main {
    public static <T extends Comparable<? super T>> T secondSmallest(List<? extends T> list) {
        T first = null;
        T second = null;

        for (T elem : list) {
            if (first == null || elem.compareTo(first) < 0) {
                second = first;
                first = elem;
            } else if (second == null || elem.compareTo(second) < 0) {
                second = elem;
            }
        }

        return second;
    }

    static void main() {
        List<String> words = List.of("banana", "apple", "cherry");
        String result = secondSmallest(words);
        System.out.println(result);

        List<Integer> ints = List.of(3, 0, 4, 1, 5, 9);
        Integer result2 = secondSmallest(ints);
        System.out.println(result2);
    }
}
