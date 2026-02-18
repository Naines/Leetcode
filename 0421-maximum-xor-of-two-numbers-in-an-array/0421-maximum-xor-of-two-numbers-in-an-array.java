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
    public int findMaximumXOR(int[] nums) {
      Trie trie = new Trie();
      for(int x: nums){
        trie.insert(x);
      }
      int maxXor =0 ;
      for(int x: nums){
        maxXor=Math.max(maxXor, trie.getMax(trie, x));
      }
      return maxXor;
    }
}