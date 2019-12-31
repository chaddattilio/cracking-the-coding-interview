package chapter01ArraysAndStrings;

public class CheckPermutation {

    public static void main(String[] args) {
        CheckPermutation permutationObj = new CheckPermutation();
        System.out.println(permutationObj.permutation("bsat", "tabs"));
    }

    String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    // Assume that comparison is case-sensitive and whitespace is significant
    // Big O is O(n log n)
    boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        return sort(s).equals(sort(t));
    }
}
