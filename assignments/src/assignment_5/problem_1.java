package assignment_5;

import java.util.*;

public class problem_1 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;
        
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.add(s);
        visited.add(s);
        
        boolean found = false;
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            
            if (isValid(current)) {
                result.add(current);
                found = true;
            }
            
            if (found) continue;
            
            for (int i = 0; i < current.length(); i++) {
                if (current.charAt(i) != '(' && current.charAt(i) != ')') continue;
                
                String next = current.substring(0, i) + current.substring(i + 1);
                
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        
        return result;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }

    public static void main(String[] args) {
        problem_1 solution = new problem_1();

        System.out.println(solution.removeInvalidParentheses("()())()"));
        System.out.println(solution.removeInvalidParentheses("(a)())()"));
        System.out.println(solution.removeInvalidParentheses(")("));
    }
}
