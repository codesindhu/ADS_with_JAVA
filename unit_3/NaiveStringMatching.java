// import java.util.Scanner;
public class NaiveStringMatching {
    
    public static void main(String[] args) {
        // Scanner sc=new Scanner(System.in);
        // System.out.println("enter a string ");
        // String text=sc.nextLine();
        // System.out.println("enter a pattern");
        // String pattern=sc.nextLine();

        String text = "ababcabcabababd";
        String pattern = "ababd";
        naiveStringMatch(text, pattern);
    }

    public static void naiveStringMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                System.out.println("Pattern found at index " + i);
            }
        }
    }
}
