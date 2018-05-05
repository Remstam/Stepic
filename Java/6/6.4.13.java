import java.util.*;

public class Main {
    private static Comparator<Map.Entry<String, Integer>> cmp() {
        return Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                    .reversed() // swap string and int
                    .thenComparing(Map.Entry::getKey);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("[^\\p{L}\\p{Digit}]+"); // not any letter and not any digit 1+ times
        
        Map<String, Integer> map = new HashMap<>();
        // sum frequences
        scanner.forEachRemaining(x -> map.merge(x.toLowerCase(), 1, (f1, f2) -> f1 + f2));
        
        map
            .entrySet()
            .stream()
            .sorted(cmp())
            .limit(10)
            .map(Map.Entry::getKey)
            .forEach(System.out::println);
    }
}
