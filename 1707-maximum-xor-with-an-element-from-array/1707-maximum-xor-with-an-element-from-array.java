class Solution {
    static class Trie{
        Trie kids[];
        Trie(){
            kids = new Trie[2];
        }

        void insert(int n){
            Trie curr = this;
            for(int i=31;i>=0;i--){
                int bit = (n>>i)&1;
                if(curr.kids[bit]==null)
                    curr.kids[bit]=new Trie();
                curr = curr.kids[bit];
            }
        }

        public int getMax(Trie root, int x){
            Trie curr = root;
            int maxXor = 0;
            for(int i=31;i>=0;i--){
                int bit = (x>>i)&1;
                if(curr.kids[1-bit]!=null){
                    maxXor |= (1<<i);
                    curr=curr.kids[1-bit];
                }else{
                    curr=curr.kids[bit];
                }
            }
            return maxXor;
        }
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int ql = queries.length;
        int ans[]=new int[ql];
        int temp[][]=new int[ql][3];
        for(int i=0;i<ql;i++){
            temp[i][0]=queries[i][0];
            temp[i][1]=queries[i][1];
            temp[i][2]=i;
        }
        //sort on basis of ai
        Arrays.sort(temp, (a, b)->{
            return a[1]-b[1];
        });
        Arrays.sort(nums);
        Trie root = new Trie();
        int idx=0;

        for(int q[]: temp){
            while(idx<nums.length && nums[idx]<=q[1]){
                root.insert(nums[idx]);
                idx++;
            }
            if(nums[0]>q[1])
                ans[q[2]] = -1;
            else
                ans[q[2]] = root.getMax(root,q[0]);
        }

        return ans;
    }
}