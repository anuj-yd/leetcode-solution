class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int len = m+n-1;
        int i = m-1;
        int j = n-1;

        while(j>=0 && i>=0){
            if(nums1[i]>=nums2[j]){
                nums1[len] = nums1[i];
                len--;
                i--; 
            }else if(nums1[i]<=nums2[j]){
                nums1[len] = nums2[j];
                len--;
                j--; 
            }

        }
        while(j>=0){
            nums1[len] = nums2[j];
            j--;
            len--;
        }

    
    }
}