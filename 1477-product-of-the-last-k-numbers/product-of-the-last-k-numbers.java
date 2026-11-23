class ProductOfNumbers {

    List<Integer> ans;
    public ProductOfNumbers() {
        this.ans = new ArrayList<>();
    }
    public void add(int num) {
        ans.add(num);
    }
    
    public int getProduct(int k) {
        int size = ans.size();
        int res = 1;

        for(int i=size-1;i>=size-k;i--){
            res *= ans.get(i);
        }
        return res;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */