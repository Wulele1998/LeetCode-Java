import OA.DinosaurSpeed;
import OA.OneEditDistance;

import static org.junit.Assert.*;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = -102;

        System.out.println(b / a);
        System.out.println(b % a);
        System.out.println(Math.floorDiv(b, a));
        System.out.println(Math.floorMod(b, a));
    }
}
