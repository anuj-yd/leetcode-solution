class Solution {
    int count=0;

    public void pairCount(int[] arr1,int n1,int[] arr2,int n2){
        int i = 0;
        int j = 0;
        while(i<n1){
            while(j<n2 && (long)arr1[i] > 2L*arr2[j]){
                j++;
            }
            count+=j;
            i++;
        };

    }

    public void merge(int[] nums,int l,int mid,int r){
        int n1 = mid-l+1;
        int n2 = r-mid;

        int idx1 = l;

        int larr[] = new int[n1];

        for(int i=0;i<n1;i++){
            larr[i] = nums[idx1++];
        }

        int idx2 = mid+1;
        int rarr[] = new int[n2];

        for(int i=0;i<n2;i++){
            rarr[i] = nums[idx2++];
        }

        pairCount(larr,n1,rarr,n2);

        int i=0;
        int j=0;
        int idx = l;

        while(i<n1 && j<n2){
            if(larr[i]<=rarr[j]){
                nums[idx++]=larr[i++];
            }else{
                nums[idx++] = rarr[j++];
            }
        } 

        while(i<n1){
            nums[idx++] = larr[i++];
        }

        while(j<n2){
            nums[idx++] = rarr[j++];
        }



    }
    public void solve(int[] nums,int l,int r){
        if(l==r) return;
        int mid = l+(r-l)/2;
        solve(nums,l,mid);
        solve(nums,mid+1,r);

        merge(nums,l,mid,r);
    }
    public int reversePairs(int[] nums) {

        int n = nums.length;
        solve(nums,0,n-1);
        return count;
    }
}