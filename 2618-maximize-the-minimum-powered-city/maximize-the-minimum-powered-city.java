class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        
        // Calculate initial coverage using prefix sums
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stations[i];
        }
        
        long[] power = new long[n];
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n - 1, i + r);
            power[i] = prefix[right + 1] - prefix[left];
        }
        
        // Binary search
        long left = 0, right = (long) 1e15;
        long answer = 0;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (canAchieve(power, r, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    private boolean canAchieve(long[] power, int r, long k, long target) {
        int n = power.length;
        long[] arr = power.clone();
        long[] diff = new long[n + 1];
        long currAdd = 0;
        long used = 0;
        
        for (int i = 0; i < n; i++) {
            currAdd += diff[i];
            long currPower = arr[i] + currAdd;
            
            if (currPower < target) {
                long need = target - currPower;
                if (used + need > k) return false;
                
                used += need;
                currAdd += need;
                
                // The added stations at position i will affect up to i + 2*r
                int end = i + 2 * r + 1;
                if (end < n) {
                    diff[end] -= need;
                }
            }
        }
        
        return true;
    }
}