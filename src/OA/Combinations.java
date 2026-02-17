package OA;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<Integer> res;
    public List<Integer> getProducts(List<Integer> primes) {
        res = new ArrayList<>();

        recursion(0, 1, primes);
        return res;
    }

    private void recursion(int index, int product, List<Integer> primes) {
        if (index == primes.size()) {
            if (product != 1)
                res.add(product);
            return;
        }

        // use current prime number
        recursion(index + 1, product * primes.get(index), primes);
        // don't use current prime number
        recursion(index + 1, product, primes);
    }

    public static void main(String[] args) {
        Combinations test = new Combinations();
        List<Integer> primes = List.of(2, 3, 5, 7);
        System.out.println(test.getProducts(primes));
    }
}
