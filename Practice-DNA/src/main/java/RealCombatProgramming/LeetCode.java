package RealCombatProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeetCode {
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(target - numbers[i])) {
                map.put(numbers[i], i);
            } else {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
        }
        throw new IllegalArgumentException("Two numbers not found");
    }

    public static int[] twoSumII(int[] arr, int target) {
        //Sorting and Two Pointer
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int[] result = new int[2];
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                result[0] = arr[left];
                result[1] = arr[right];
                return result;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }

    public static boolean iSubsequence(String str, String seq) {
        int i = 0; // traverse str "abscde"
        int j = 0; // traverse seq "aec"

        while (i < str.length() && j < seq.length()) {
            if (str.charAt(i) == seq.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == seq.length();
    }

    public static int firstNonRepeatingCharacter(String str) {
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            characterFrequencyMap
                    .put(ch, characterFrequencyMap.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (characterFrequencyMap.get(ch) == 1) {
                return 1;
            }
        }
        return -1;
    }

    public String removeVowels(String str) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        StringBuilder sb = new StringBuilder();

        char[] charArray = str.toCharArray();
        for (Character ch : charArray){
            if(!vowels.contains(ch)) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public long reverseInt(int number){
        boolean isNegative = number < 0;
        if(isNegative){
            number = number * -1;
        }
        long reverse = 0;
        int lastDigit;
        while(number > 0){
            lastDigit = number % 10;
            reverse = reverse * 10 + lastDigit;
            number = number / 10;
        }
        return isNegative ? reverse * -1 : reverse;
    }

    public static void main (String[] args){

    }
}