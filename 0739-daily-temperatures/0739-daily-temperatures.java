class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> S = new Stack<>();
        int[] ans = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {

            while (!S.empty() && temperatures[i] >= temperatures[S.peek()]) {
                S.pop();
            }

            if (S.empty())
                ans[i] = 0;
            else
                ans[i] = S.peek() - i;

            S.push(i);
        }

        return ans;
    }
}