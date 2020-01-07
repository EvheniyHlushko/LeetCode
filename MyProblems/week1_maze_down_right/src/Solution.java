import java.util.HashSet;

public class Solution {
    public boolean pathExists(int[][] arr){
        return pathExistsAllWays(arr, new Pair(0,0), new HashSet<Pair>());
    }

    private boolean pathExistsTwoWays(int[][] arr, int i, int j){
        if(arr.length <= j || arr[0].length <= i || arr[i][j] == 1){
            return false;
        }

        if(arr.length - 1 == i && arr[0].length - 1 == j){
            return true;
        }

        return pathExistsTwoWays(arr, i + 1, j) || pathExistsTwoWays(arr, i, j + 1);
    }

    private boolean pathExistsAllWays(int[][] arr, Pair pair, HashSet<Pair> map){
        int i = pair.i;
        int j = pair.j;

        if(arr.length <= i || arr[0].length <= j || i < 0 || j < 0 || map.contains(pair)){
            return false;
        }

        if(arr[i][j] == 1){
            //  map.add(pair);
            return false;
        }

        map.add(pair);

        if(arr.length - 1 == i && arr[0].length - 1 == j){
            return true;
        }
        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair(i, j + 1);
        pairs[1] = new Pair(i, j - 1);
        pairs[2] = new Pair(i + 1, j );
        pairs[3] = new Pair(i - 1, j );

        for (Pair pairItem :
                pairs) {
            if(pathExistsAllWays(arr, pairItem, map)){
                return true;
            }
        }
        return false;
    }

    private class Pair{
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }

        Integer i;
        Integer j;

        @Override
        public int hashCode() {
            return this.i.hashCode() + this.j.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Pair item = (Pair)obj;
            return item.i == i && item.j == j;
        }
    }
}
