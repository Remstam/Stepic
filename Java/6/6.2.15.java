import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<Integer>();
        int step = 0;
        
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int temp = scanner.nextInt();
            if ((step & 1) != 0) {
                nums.add(temp);
            }
            
            step++;
        }
        
        Collections.reverse(nums);
        nums.forEach(x -> System.out.print(x + " "));
    }
}
