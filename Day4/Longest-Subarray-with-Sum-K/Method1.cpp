class Solution
{
public:
    int longestSubarray(vector<int> &arr, int k)
    {
        // code here
        unordered_map<int, int> prefix;
        int maxlength = 0, sum = 0, n = arr.size();

        for (int i = 0; i < n; i++)
        {
            sum += arr[i];
            if (sum == k)
                maxlength = max(maxlength, i + 1);
            if (prefix.find(sum - k) != prefix.end())
            {
                int len = i - prefix[sum - k];
                maxlength = max(maxlength, len);
            }

            if (prefix.find(sum) == prefix.end())
                prefix[sum] = i;
        }

        return maxlength;
    }
};