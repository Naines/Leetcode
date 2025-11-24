class Solution {


    //first bp and select digit from right immediately larger
    //swap and reverse
    public void nextPermutation(int[] arr) {
        int i=arr.length-2;

       while(i>=0 && arr[i]>=arr[i+1]) i--;


       //find next high of i, right side
       if(i>=0){
            int j = arr.length -1;
            while(arr[j] <= arr[i])
                j--;
            swap(i, j, arr);
        }

        reverse(i+1, arr);
    }

    public void swap(int a, int b, int arr[]){
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public void reverse(int start, int arr[]){
        int n = arr.length;
        while(start<n-1){
            swap(start, n-1, arr);
            start++;
            n--;
        }
    }
}