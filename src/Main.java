import java.util.*;

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

        Deque<Integer> deque = new ArrayDeque<>();

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        map1.put('#', 100);
        map2.put('#', 100);

        System.out.println(map1.get('#').equals((map2.get('#'))));

        Map<Integer, List<Integer>> map3 = new HashMap<>();
        map3.computeIfAbsent(1, _ -> new ArrayList<>()).add(0);
        System.out.println(map3.get(1));
    }
}
