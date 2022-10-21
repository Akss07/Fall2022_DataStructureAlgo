package com.neu.algo.assignment3;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parentheses (https://leetcode.com/problems/generate-parentheses/)
 */
public class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis(c))
                    for (String right: generateParenthesis(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }
}
