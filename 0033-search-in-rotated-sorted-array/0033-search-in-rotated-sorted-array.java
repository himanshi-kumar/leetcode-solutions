class Solution {
    public int search(int[] arr, int k) {
        int start = 0;
        int end = arr.length-1;
        int ans = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==k){
                ans = mid;
                break;
            }
            if(arr[start]<=arr[mid]){
                if(arr[start]<=k && arr[mid]>k){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }else{
                if(arr[mid]<k && k<=arr[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return ans ;

    }
}