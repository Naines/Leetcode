class Solution {

    //m1: for(word0....wordn), goto cell(0,0)...(n-1,n-1)
    //find all words
    //o(numWords* on(n^2))

    //m2.build trie of words and then, transverse for each charon board in trie.
    //if word found, add to res

    Set<String> res = new HashSet<>();
    char board[][];
    String words[];
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.words = words;
        Trie trie= new Trie();
        for(String word: words){
            trie.add(word);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfsOnTrie(i, j, trie);
            }
        }
        return new ArrayList<>(res);
    }

    void dfsOnTrie(int i, int j, Trie root){
        //gothru the root, and find the word exisitng in set
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]=='*' || root.kids[board[i][j]-'a']==null){
            return;
        }

        if(root.kids[board[i][j]-'a'].word!=null) {
            res.add(root.kids[board[i][j]-'a'].word);
        }

        root = root.kids[board[i][j]-'a'];
        char c = board[i][j];
        board[i][j] = '*';
        dfsOnTrie(i-1, j,root);
        dfsOnTrie(i+1, j,root);
        dfsOnTrie(i, j-1,root);
        dfsOnTrie(i, j+1,root);
        board[i][j]=c;
    }

    static class Trie{
        String word;
        Trie kids[]=new Trie[26];
        Trie(){
        }
        void add(String key) {
            Trie curr = this;
            for (int i = 0; i < key.length(); i++) {
                int index = key.charAt(i) - 'a';
                if (curr.kids[index] == null)
                    curr.kids[index] = new Trie();
                curr = curr.kids[index];
            }
            curr.word = key;
        }
    }
}