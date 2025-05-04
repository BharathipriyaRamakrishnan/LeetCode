import java.util.*;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charIndex = new HashMap<>();
        int maxLength = 0;
        int left = 0; // Start of sliding window

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already seen and within the current window
            if (charIndex.containsKey(currentChar) && charIndex.get(currentChar) >= left) {
                left = charIndex.get(currentChar) + 1;
            }

            charIndex.put(currentChar, right); // Update the last index of the character
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
