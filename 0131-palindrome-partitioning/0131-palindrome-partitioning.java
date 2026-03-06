class Solution {

    //aaabb
    //left

    //substring palindrome is required and not subsequence
    //hence string.substring van be used.
    //if left is palin, dfs on (right)

    //a -> (aabb) -> a -> (abb) -> a -> bb -> b -> b
    //aa -> abb 
    //aab -> bb
    

    //need to use map to save TLE

    Map<String , Boolean> map =new HashMap<>();
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(new ArrayList<>(), s);
        return ans;
    }

    void dfs(ArrayList<String> list,String s){
        if(0==s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        // System.out.println("IN AT"+s);
        for(int i=0;i<s.length();i++){
            String left = s.substring(0, i+1);
            if(isPalin(left)){
                list.add(left);
                
                String right = s.substring(i+1);
                dfs(list, right);
                list.remove(list.size()-1);
              
            }
        }
        // map.put(s, false);
        return;
    }

    boolean isPalin(String word){
        int l=0, r=word.length()-1;
        while(l<r){
            if(word.charAt(l)==word.charAt(r)){
                l++;r--;
            }else{
                return false;
            }
        }
        return true;
    }
}