import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
    }

    // task 1
    public static String returnOddIndexNames(List<String> names) {
        Predicate<Integer> predicate = i -> i % 2 != 0;
        return names.stream()
                .filter(i -> predicate.test(names.indexOf(i)))
                .map(s -> names.indexOf(s) + ". " + s + "\n")
                .collect(Collectors.joining());
    }

    // task 2
    public static List<String> getReversedSortedInUpperCase(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    // task 3
    public static String getSortedNumbersFormString(String[] arr) {
        return Arrays.stream(String.join("", arr).split(""))
                .filter(i -> i.matches("\\d"))
                .map(Integer::valueOf)
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(",", "", ""));
    }

    // task 4
    void randomGenerator(long seed, long a, long c, long m) {
        Stream.iterate(seed, x -> (a * x + c) % m);
    }

    // task 5
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iterator1 = first.iterator();
        Iterator<T> iterator2 = second.iterator();
        Stream<T> result = Stream.empty();

        while (iterator1.hasNext() && iterator2.hasNext()) {
            result = Stream.concat(result, Stream.of(iterator1.next(), iterator2.next()));
        }
        return result;
    }

}