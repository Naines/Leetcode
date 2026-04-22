//.
//......
//a
//p n
//ep t
//l
//e
class Trie {
    Trie kids[];
    boolean end;
    public Trie() {
        //create root node
        kids=new Trie[26];
        end=false;
    }
    
    public void insert(String word) {
        //go through each char, and keep inserting by finding the node
        Trie curr=this;
        for(char c: word.toCharArray()){
            int idx=c-'a';
            if(curr.kids[idx]==null)
                curr.kids[idx]=new Trie();
            curr=curr.kids[idx];
        }
        curr.end=true;
    }
    
    public boolean search(String word) {
        Trie curr=this;
        for(char c: word.toCharArray()){
            int idx=c-'a';
            if(curr.kids[idx]==null) return false;
            curr=curr.kids[idx];
        }
        //reached end here
        return curr.end==true;
    }
    
    public boolean startsWith(String prefix) {
        Trie curr=this;
        for(char c: prefix.toCharArray()){
            int idx=c-'a';
            if(curr.kids[idx]==null) return false;
            curr=curr.kids[idx];
        }
        //reached end here
        return true;
    }


}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */