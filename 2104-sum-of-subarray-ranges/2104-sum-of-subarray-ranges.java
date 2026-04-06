class Solution {

    //O(n)
    //minStack to get elements smaller in range
    //maxStack to get elements larger in range
    //while pop, calculate the ld and rd for both
    //ans = num of subarray where 
    //nums[i] is max - num of subarray where nums[i] is min
    //(a1-b1)+(a2-b2) = (a1+a2)-(b1+b2)
     public long subArrayRanges(int[] nums) {
        int n =nums.length;
        long res=0;
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<=n;i++){
            while(!stk.isEmpty() && (i==n || nums[stk.peek()]>=nums[i])){
                int t=stk.pop();
                //4,-2
                //stk: 4 popped, is empty
                long left = t- (stk.isEmpty()?-1:stk.peek());
                long right = i-t;
                res-=(long)nums[t]*left*right;
            }
            stk.push(i);
        }
        stk.clear();

        for(int i=0;i<=n;i++){
            while(!stk.isEmpty() && (i==n || nums[stk.peek()]<=nums[i])){
                int t=stk.pop();
                long left = t- (stk.isEmpty()?-1:stk.peek());
                long right = i-t;
                res+=(long)nums[t]*left*right;
            }
            stk.push(i);
        }
        return res;
    }

    //BRUTE FORCE
    // public long subArrayRanges(int[] nums) {
    //     int n =nums.length;
    //     long res=0;
    //     for(int i=0;i<n;i++){
    //         int min=nums[i], max=nums[i];
    //         //i...j
    //         //1..4
    //         //2..4
    //         //3..4
    //         //4..4
    //         for(int j=i;j<n;j++){
    //             min=Math.min(min, nums[j]);
    //             max=Math.max(max, nums[j]);
    //             res+=max-min;
    //         }
    //     }
    //     return res;
    // }
}