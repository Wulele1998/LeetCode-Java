import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = -102;

        System.out.println(b / a);
        System.out.println(b % a);
        System.out.println(Math.floorDiv(b, a));
        System.out.println(Math.floorMod(b, a));

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };

        String path = "/a/b/c";
        System.out.println(Arrays.toString(path.split("/")));
    }
}
