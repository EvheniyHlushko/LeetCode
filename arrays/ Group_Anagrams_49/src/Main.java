public class Main {
    public static void main(String[] args) {

        var solution = new Solution();

        var array = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        var result = solution.groupAnagrams(array);

        System.out.print(result);
    }
}
