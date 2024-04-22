public class KMPAlgorithm {

    public static void main(String[] args) {
        String text = "ababcabcabababd";
        String pattern = "ababd";
        kmpSearch(text, pattern);
    }

    public static void kmpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        
        // Compute longest prefix suffix array
        int[] lps = computeLPSArray(pattern);
        
        int i = 0; // Index for text[]
        int j = 0; // Index for pattern[]
        
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    public static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0
        
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
