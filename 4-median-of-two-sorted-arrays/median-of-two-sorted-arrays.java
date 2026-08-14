class Solution {
    public double findMedianSortedArrays(int[] a,int[] b) {  
        if(a.length>b.length){
            return findMedianSortedArrays(b,a);
        }
        
        int m = a.length;
        int n = b.length;
        int l = 0;
        int h = m;
        
        while(l<=h){
            int mid = l+(h-l)/2;
            
            int px = mid;
            int py = (m+n+1)/2 - px;
            
            int x1 = (px==0) ? Integer.MIN_VALUE : a[px-1];
            int x2 = (py==0) ? Integer.MIN_VALUE : b[py-1];
            int x3 = (px==m) ? Integer.MAX_VALUE : a[px];
            int x4 = (py==n) ? Integer.MAX_VALUE : b[py];
            
            if(x1<=x4 && x2<=x3){
                
                if((m+n)%2==1){
                    return Math.max(x1,x2);
                }
                
                return (Math.max(x1,x2)+Math.min(x3,x4))/2.0;
                
            }
            if(x1>x4){
                h=mid-1;
            }else{
                l=mid+1;
            }
            
        }
        return -1; 
    }
}