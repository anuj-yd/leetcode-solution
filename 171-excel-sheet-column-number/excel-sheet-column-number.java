class Solution {
    public int titleToNumber(String columnTitle) {
        int r=0;
        char[] c = columnTitle.toCharArray();
        for(int i=0;i<c.length;i++){
            int n = c[i]-65+1;
            r = r *26+n;
        }
        return r;
    }
}