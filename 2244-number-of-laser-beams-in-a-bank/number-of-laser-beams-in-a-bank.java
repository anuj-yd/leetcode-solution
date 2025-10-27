class Solution {
    public int numberOfBeams(String[] bank) {

        List<Integer> ans = new ArrayList<>();
        for(String str : bank){
            int count = 0;
            char ch[] = str.toCharArray();
            for(int i=0;i<ch.length;i++){
                if(ch[i]=='1'){
                    count++;
                }
            }
            if(count!=0) ans.add(count);
        }

        //for(int i = 0;i<bank.length;i++){
            // int num = Integer.parseInt(bank[i]);
            // while(num!=0){
            //     count+=num&1;
            //     num=num>>1;
            // }
            // ans.add(count);
            
            // count = 0;
        //}

        int pro = 0;
        for(int i=1;i<ans.size();i++){
            pro += (ans.get(i-1)*ans.get(i));
        }
        return pro;
        
    }
}