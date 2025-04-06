class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0;
        
        int maxLen = 0;
        int i = 1;
        
        while (i < n - 1) {
            // Check if current element is a peak
            if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                int left = i - 1;
                // Expand to the left
                while (left > 0 && arr[left] > arr[left-1]) {
                    left--;
                }
                
                int right = i + 1;
                // Expand to the right
                while (right < n - 1 && arr[right] > arr[right+1]) {
                    right++;
                }
                
                // Calculate mountain length
                int currentLen = right - left + 1;
                maxLen = Math.max(maxLen, currentLen);
                
                // Move to the end of this mountain
                i = right;
            } else {
                i++;
            }
        }
        
        return maxLen;
    }
}