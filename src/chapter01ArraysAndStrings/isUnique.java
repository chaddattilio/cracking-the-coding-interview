package chapter01ArraysAndStrings;

public class isUnique {

    public static void main(String[] args) {
        isUnique charString = new isUnique();
        System.out.println(charString.isUniqueChars("chad"));
    }

    // Assumes only ASCII characters
    // boolean array "char_set" keeps track of duplicates - so char_set['a'] (or char_set[97]) would be true for "chad"
    // Big O would be O(n), where n is length of string (could argue it's O(1) since never would go above 128 chars, or O(c))
    boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }

        return true;
    }

    // Uses a bit array for more efficiency
    // Assume characters are only a-z lowercase - allows us to use a single int ("checker")
    // Big O is still O(n) but space complexity is now reduced by a factor of 4
    boolean isUniqueCharsBits(String str) {
        int checker = 0;
        for (int i = 0; i <str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}
