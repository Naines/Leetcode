class Solution {
    //if in map, find par and union(par, i);
    //now to build the map, transverse again, find parent of email list index 
    //and put in map<String, Set<String>> 
    //convert map<string, set<String>> to list<list<string>>
    //add name to idx 0 of everylist
    public List<List<String>> accountsMerge(List<List<String>> acs) {
        
        if(acs.size()==0){
            return new ArrayList<>();
        }
        int n=acs.size();
        UnionFind uf=new UnionFind(n);
        Map<String, Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<acs.get(i).size();j++){
                String currMail = acs.get(i).get(j);
                if(map.containsKey(currMail)){
                    int par = map.get(currMail);
                    uf.union(par, i);
                }else{
                    map.put(currMail, i);
                }
            }
        }

        Map<Integer, Set<String>> ds=new HashMap<>();
        for(int i=0;i<n;i++){
            int par=uf.find(i);
            ds.putIfAbsent(par, new HashSet<>());
            Set<String> cs = ds.get(par);
            for(int j=1;j<acs.get(i).size();j++){
                cs.add(acs.get(i).get(j));
            }
            ds.put(par, cs);
        }

        List<List<String>> result = new ArrayList<>();
        for(int idx: ds.keySet()){
            List<String> cl=new ArrayList<>();
            if(ds.containsKey(idx)){
                cl.addAll(ds.get(idx));
            }
            Collections.sort(cl);
            cl.add(0, acs.get(idx).get(0));
            result.add(cl);
        }
        return result;
    }


    class UnionFind {
        int size;
        int[] parent;
        public UnionFind(int size) {
            this.size = size;
            this.parent = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public void union(int a, int b) {
            parent[find(a)] = parent[find(b)];
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}