class Solution {
    //12,21,45,33,54
    //f(0,1) -> rev(nums[0]) = rev(12) = 21 = nums[1]. dist=1
    //f(2,4) -> rev(nums[2]) = rev(45) = 54 = nums[4], dist=2
    //i=0....n-1
    //j=i...n-1

    //if(reverse(i)==nums[j] || reverse(j)==nums[i])
    //  ans = Math.min(ans, Math.abs(j-i));


    //2 sum:
    //reverse(i), add to map.
    //if(map.contains(i)) calAns(i, map.get(rev(nums[i])));


    //120, 21
    //(12,0) 12

    //12, 120

    //12,0  120-> 21
    public int minMirrorPairDistance(int[] nums) {
        int ans = Integer.MAX_VALUE;
        Map<Integer, Integer> map=new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){           
            if(map.containsKey(nums[i])){
                ans = Math.min(ans, i-map.get(nums[i]));
            }
            
            map.put(reverse(nums[i]), i);
            //System.out.println(map);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    int reverse(int n){
        int num=n, rev=0;
        while(num>0){
            int d = num%10;
            rev = rev*10+d;
            num=num/10;
        }
        return rev;
    }
}