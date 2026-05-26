class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int totsum =0;
        for(int i=0;i<n;i++){
            if(customers.charAt(i)=='Y'){
                totsum++;
            }
        }
        int sum = totsum;
        int penalty = 0;
        for(int i=0;i<n;i++){
            if(customers.charAt(i)=='N'){
                sum--;
            }else if(customers.charAt(i)=='Y'){
                sum++;
            }

            if(totsum<sum){
                sum = totsum;
                penalty = i+1;
            }
        }

        return penalty;
        
    }
}