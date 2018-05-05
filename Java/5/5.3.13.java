import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double sum = 0.0;
        
        while (s.hasNext()) {
            try {
                sum += Double.parseDouble(s.next());
            } catch (Exception e) {};
        }
        
        System.out.format("%.6f", sum);
    }
}
