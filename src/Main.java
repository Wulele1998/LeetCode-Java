import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = -102;

        System.out.println(b / a);
        System.out.println(b % a);
        System.out.println(Math.floorDiv(b, a));
        System.out.println(Math.floorMod(b, a));

        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(5, "red");
        map.put(8, "blue");
        map.put(0, "green");

        System.out.println(map.floorKey(7));
        System.out.println(map.ceilingKey(7));

        String s = map.get(10);
        System.out.println(s == null ? "null" : s);
    }
}
