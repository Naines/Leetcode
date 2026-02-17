class Trie {
    Trie kids[];
    boolean end;
    public Trie() {
        kids = new Trie[26];
        end = false;
    }
    
    public void insert(String word) {
        Trie curr = this;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.kids[idx]==null)
                curr.kids[idx]=new Trie();
            curr= curr.kids[idx];
        }
        curr.end = true;
    }
    
    public boolean search(String word) {
        Trie curr = this;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(curr.kids[idx]==null)
                return false;
            curr = curr.kids[idx];
        }
        return curr.end;
    }
    
    public boolean startsWith(String prefix) {
        Trie curr =this;
        for(int i=0;i<prefix.length();i++){
            int idx = prefix.charAt(i)-'a';
            if(curr.kids[idx]==null){
                return false;
            }
            curr = curr.kids[idx];
        }
        //reached end
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