package medium;

import java.util.*;

/**
 * 题目：Hot 100 17. 电话号码的字母组合
 * 题目要求：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *         给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 题目分析：1. 方法一：回溯法
 */
public class Code17 {

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }

        Map<Character, String> phoneMap = new HashMap() {
            {put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");}
        };
        backtrack(combinations, phoneMap, digits, 0 , new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index+1, combination);
                combination.deleteCharAt(index);
            }

        }
    }
}
