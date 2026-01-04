class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;

        for (int num : nums) {
            int count = 0;
            int sum = 0;

            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    int d1 = i;
                    int d2 = num / i;

                    if (d1 == d2) {
                        count++;
                        sum += d1;
                    } else {
                        count += 2;
                        sum += d1 + d2;
                    }
                }
            }

            if (count == 4) {
                ans += sum;
            }
        }
        return ans;
    }
}


// class Solution {
//     public int sumFourDivisors(int[] nums) {
//         int ans = 0;
//         for(int num : nums){
//             if(num%2==0){
//                 int sum = num+1;
//                 int count = 0;
//                 int n = num/2;
//                  for(int i = 2;i<=n;i+=2){
//                     if(num%i==0){
//                         count++;
//                         sum+=i;
//                     }
//                 }
//                 if(count==2) ans += sum;
                
//             }else{
//                 int sum = num+1;
//                 int count = 0;
//                 int n = (num+1)/2;
//                 for(int i = 3;i<=n;i+=2){
//                     if(num%i==0){
//                         count++;
//                         sum+=i;
//                     }
//                 }
//                 if(count==2) ans += sum;
//             }
//         }
//         return ans;

        
//     }
// }