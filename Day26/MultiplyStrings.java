/*
Problem: Multiply Strings
Platform: LeetCode
Topic: Math / String

Approach:
Multiply each digit of num1 with each digit of num2, just like manual multiplication.
Store the results in an array of size `m + n`. The position for the product of
`num1[i]` and `num2[j]` will be `i + j` and `i + j + 1`. Handle carry over.
Skip leading zeros when building the final string.

Time Complexity: O(M * N)
Space Complexity: O(M + N) for the result array
*/

class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];
                
                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  
        
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
