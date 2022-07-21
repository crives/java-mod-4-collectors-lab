import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    /*
    Write a method called multiplySquaresOfNumbers that takes in a List<Integer> and returns the
    product of squares of the integer numbers as a long.
    Use the reducing method in the Collectors class for this problem.
     */

    // modify this method
    public static long multiplySquaresOfNumbers(List<Integer> numbers) {
        long l = numbers
                    .stream()
                    .map(i -> i * i)
                    .collect(Collectors.reducing((runningTotal, currentStreamValue)
                            -> runningTotal * currentStreamValue))
                    .stream()
                .mapToLong(Integer::longValue)
                .findAny()
                .getAsLong();
        return l;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] values = scanner.nextLine().split(" ");

        List<Integer> numbers = new ArrayList<>();
        for (String val : values) {
            numbers.add(Integer.parseInt(val));
        }

        long val = multiplySquaresOfNumbers(numbers);

        System.out.println(val);

        scanner.close();
    }
}