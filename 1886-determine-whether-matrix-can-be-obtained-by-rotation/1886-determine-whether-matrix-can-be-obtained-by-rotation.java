class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
       
         int h =mat.length, w=mat[0].length;
        for(int k=0;k<4;k++){
             rotate(mat);
            if(compare(mat, target, h, w)) return true;
        }
        
        return false;
    }
    boolean compare(int mat[][], int target[][], int h, int w){
        boolean equal = true;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(target[i][j]!=mat[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        return equal;
    }

    void rotate(int mat[][]){
        int h =mat.length, w=mat[0].length;
        for(int i=0;i<h/2;i++){
            reverse(mat, i, h, w);
        }
        for(int i=0;i<h;i++){
            for(int j=i+1;j<w;j++){
                int t= mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=t;
            }
        }
    }

    void reverse(int mat[][], int i, int h, int w){
        for(int j=0;j<w;j++){
            int t= mat[i][j];
            mat[i][j]=mat[h-i-1][j];
            mat[h-i-1][j]=t;
        }
    }
}