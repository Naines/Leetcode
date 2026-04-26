class Solution {
    //add 1 to first, last idx allowed by rowNum
    //j=1, 1..1 list.add(1) to first and last idx 
    //j=2  1..2 list.add(1) to first, last
    //j=3, 1.2.3 list.add(1) to list.get(i-1) and list.get(0) add()
    //j=3, if(i>=3 && j>1 && j<=i), mid nodes ->
    //int a=list.get(i-1).get(j-1).
    //int b=list.get(i-1).get(j)
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> list = new ArrayList<>();
        // for(int i=1;i<=n;i++){
        //     list.add(new ArrayList<>());
        //     for(int j=1;j<=i;j++){
              
        //         if(i>=3){
        //             int a=list.get(i-2).get(j-1)+list.get(i-2).get(j-2);
        //             System.out.println(i+" "+j+" "+a);
        //             list.get(i-1).add(a);
        //         }else if(i==1){
        //             list.get(i-1).add(1);
        //         }else if(i==2){
        //             list.get(i-1).add(1);
        //             list.get(i-1).add(1);
        //         }
        //     }
        // }
        int arr[][]=new int[n][n];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if(j==1){
                    arr[i-1][j-1] = 1; 
                }else if(j==i){
                    arr[i-1][j-1]=1;
                }else{
                    arr[i-1][j-1]=arr[i-2][j-1]+arr[i-2][j-2];
                }
            }
        }

        for(int i=1;i<=n;i++){
            list.add(new ArrayList<>());
            for(int j=1;j<=i;j++){
                list.get(i-1).add(arr[i-1][j-1]);
            }
        }
        return list;
        
    }
}