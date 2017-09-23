package cn.imaq.java9demo;

import java.util.*;

public class CollectionsDemo {
    public static void java9() {
        List<String> list = List.of("a", "b", "c");
        Set<String> set = Set.of("a", "b", "c");
        Map<String, Integer> map = Map.ofEntries(
                Map.entry("a", 1),
                Map.entry("b", 2),
                Map.entry("c", 3)
        );
    }

    public static void java8() {
        List<String> list = Collections.unmodifiableList(Arrays.asList("a", "b", "c"));
        Set<String> set = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("a", "b", "c")));
        Map<String, Integer> map = Collections.unmodifiableMap(new HashMap<>() {{
            put("a", 1);
            put("b", 2);
            put("c", 3);
        }});
    }
}
