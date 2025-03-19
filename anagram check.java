import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take two strings as input
        System.out.print("Enter the first string: ");
        String input1 = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String input2 = scanner.nextLine();

        // Check if they are anagrams
        boolean result = areAnagrams(input1, input2);

        // Output the result
        System.out.println("Are the strings anagrams? " + result);
    }

    public static boolean areAnagrams(String str1, String str2) {
        // Remove any whitespace and convert strings to lowercase
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // If lengths are not the same, they cannot be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create a frequency map for the first string
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : str1.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Decrease the frequency based on the second string
        for (char c : str2.toCharArray()) {
            if (!charCountMap.containsKey(c)) {
                return false;
            }
            charCountMap.put(c, charCountMap.get(c) - 1);
            if (charCountMap.get(c) < 0) {
                return false;
            }
        }

        // If all counts are zero, the strings are anagrams
        return true;
    }
}