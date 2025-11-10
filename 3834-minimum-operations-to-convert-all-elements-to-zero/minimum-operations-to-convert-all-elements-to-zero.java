// import java.util.Stack;

// class Solution {
//     public int minOperations(int[] nums) {
//         Stack<Integer> st = new Stack<>();
//         int ops = 0;
//         for (int num : nums) {
//             if (num == 0){
//                 st.clear();
//                 continue;
//             }
//             // remove any values greater than current num
//             while (!st.isEmpty() && st.peek() > num) {
//                 st.pop();
//             }
//             if (st.isEmpty() || st.peek() < num) {
//                 st.push(num);
//                 ops++; // each push corresponds to one operation
//             }    
//         }
//         return ops;
//     }
// }


class Solution {
    public int minOperations(int[] nums) {
        var stack = new int[nums.length + 1];
        var top = 0;
        var ans = 0;
        for (var i = 0; i < nums.length; i++) {
            while (stack[top] > nums[i]) {
                top--;
                ans++;
            }
            if (stack[top] != nums[i])
                stack[++top] = nums[i];
        }
        return ans + top;
    }
}

