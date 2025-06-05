import java.util.Stack;

public class BalancedBracketsChecker {

    public static boolean isBalanced(String input) {
        String cleaned = removeComments(input);
        return checkBrackets(cleaned);
    }

    // 1. Yorumları sil
    private static String removeComments(String code) {
        StringBuilder result = new StringBuilder();
        boolean inSingleLineComment = false;
        boolean inMultiLineComment = false;

        for (int i = 0; i < code.length(); i++) {
            if (inSingleLineComment) {
                if (code.charAt(i) == '\n') {
                    inSingleLineComment = false;
                    result.append('\n');
                }
            } else if (inMultiLineComment) {
                if (i + 1 < code.length() && code.charAt(i) == '*' && code.charAt(i + 1) == '/') {
                    inMultiLineComment = false;
                    i++; // skip '/'
                }
            } else {
                if (i + 1 < code.length() && code.charAt(i) == '/' && code.charAt(i + 1) == '/') {
                    inSingleLineComment = true;
                    i++; // skip second '/'
                } else if (i + 1 < code.length() && code.charAt(i) == '/' && code.charAt(i + 1) == '*') {
                    inMultiLineComment = true;
                    i++; // skip '*'
                } else {
                    result.append(code.charAt(i));
                }
            }
        }

        return result.toString();
    }

    // 2. Parantezleri kontrol et
    private static boolean checkBrackets(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if (!isMatchingPair(open, ch)) return false;
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    // Test
    public static void main(String[] args) {
        String[] testCases = {
            "a + (b * c) + {x / y}",
            "a + (b * c // )",
            "/* ( */ )",
            "[(])",
            "// comment only",
            "({[]})",
            "/* multi ( line */ code()"
        };

        for (String input : testCases) {
            System.out.println("Input: " + input);
            System.out.println("Balanced: " + isBalanced(input));
            System.out.println("---------------------");
        }
    }
}
