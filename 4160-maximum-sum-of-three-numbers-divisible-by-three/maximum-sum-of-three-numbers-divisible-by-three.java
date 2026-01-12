class Solution {
    public int maximumSum(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        List<Integer> ans3 = new ArrayList<>();

        for(int n : nums){
            if(n%3==0){
                ans.add(n);
            }else if(n%3==1){
                ans2.add(n);
            }else{
                ans3.add(n);
            }
        }
        Comparator<Integer> dsc = (a,b)->b-a;
        ans.sort(dsc);
        ans2.sort(dsc);
        ans3.sort(dsc);
        int msum = 0;
        if(ans.size()>=3){
            int sum = ans.get(0)+ans.get(1)+ans.get(2);
            msum = Math.max(msum,sum);
        }
        if(ans2.size()>=3){
            int sum = ans2.get(0)+ans2.get(1)+ans2.get(2);
            msum = Math.max(msum,sum);
        }

        if(ans3.size()>=3){
            int sum = ans3.get(0)+ans3.get(1)+ans3.get(2);
            msum = Math.max(msum,sum);
        }

        if(!ans.isEmpty() && !ans2.isEmpty() && !ans3.isEmpty()){
            int sum = ans.get(0)+ans2.get(0)+ans3.get(0);
            msum = Math.max(msum,sum);
        }

        return msum;
        
    }
}