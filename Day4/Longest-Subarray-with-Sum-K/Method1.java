// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> hs = new HashMap<>();

        int n = arr.length, maxLen = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == k)
                maxLen = Math.max(maxLen, i + 1);
            if (hs.containsKey(sum - k)) {
                int len = i - hs.get(sum - k);
                maxLen = Math.max(maxLen, len);
            }
            if (!hs.containsKey(sum)) {
                hs.put(sum, i);
            }
        }
        return maxLen;
    }
}
