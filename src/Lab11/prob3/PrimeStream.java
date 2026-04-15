package Lab11.prob3;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class PrimeStream {
    final Supplier<Stream<Integer>> primes = () -> Stream.iterate(2, PrimeStream::nextPrime);

    private static int nextPrime(int n) {
        int number = n + 1;
        while (!isPrime(number)) {
            number++;
        }
        return number;
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public void printFirstNPrimes(int number) {
        primes.get().limit(number).forEach(System.out::println);
    }

    public static void main(String[] args) {
        PrimeStream ps = new PrimeStream();
        ps.printFirstNPrimes(10);

        System.out.println("====");
        ps.printFirstNPrimes(5);
    }
}
