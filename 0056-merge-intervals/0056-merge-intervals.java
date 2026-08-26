class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (a,b) -> a[0] - b[0]);
        List<Pair> ans = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1 ; i < intervals.length ; i++){
            if(intervals[i][0] <= end){
                end = Math.max(end , intervals[i][1]);
            }
            else{
                ans.add(new Pair(start ,end));
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans.add(new Pair(start , end));

        int[][] result = new int[ans.size()][2];
        for(int i = 0 ; i < ans.size();i++){
            result[i][0] = ans.get(i).start;
            result[i][1] = ans.get(i).end;
        }
        return result;
    }
}
class Pair{
    int start;
    int end;
    Pair(int start , int end){
        this.start = start;
        this.end = end;
    }
}