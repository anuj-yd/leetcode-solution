class ProductOfNumbers {
    List<Integer> pro;
    public ProductOfNumbers() {
        this.pro = new ArrayList<>();
        pro.add(1);
    }
    public void add(int num) {

        if(num == 0){
            pro.clear();
            pro.add(1);
        }else{
            int val = pro.get(pro.size()-1);
            pro.add(val*num);
        }
    }
    
    public int getProduct(int k) {

        if(pro.size()<=k){
            return 0;
        }
        
        int idx = pro.size()-1;
        int v1 = pro.get(idx);
        int idx2 = pro.size()-k-1;
        int v2 = pro.get(idx2);
        
        return v1 / v2;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */