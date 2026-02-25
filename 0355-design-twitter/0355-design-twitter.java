class Twitter {
   
    Map<Integer, Set<Integer>> graph;
    Map<Integer, List<int[]>> tweets;
    int time =0;
    public Twitter() {
        graph = new HashMap<>();
        //userId, t[time][tId]
        tweets=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        List<Integer> ans = new ArrayList<>();

        //add for current user
        if(tweets.containsKey(userId)){
            for(int tweet[]: tweets.get(userId)){
                pq.add(tweet);
                if(pq.size()>10) pq.poll();
            }
        }
        
        //add for following user
        if(graph.containsKey(userId)){
            for(int following: graph.get(userId)){
                if(tweets.containsKey(following)){
                    for(int tweet[]: tweets.get(following)){
                    pq.add(tweet);
                    if(pq.size()>10) pq.poll();
                    }
                }
            }
        }
         while(pq.size()>0)
         ans.addFirst(pq.poll()[1]);
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = graph.getOrDefault(followerId, new HashSet<>()); 
        set.add(followeeId); 
        graph.put(followerId, set);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(graph.containsKey(followerId)){
           Set<Integer> followerSet = graph.get(followerId);
           followerSet.remove(Integer.valueOf(followeeId));
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */