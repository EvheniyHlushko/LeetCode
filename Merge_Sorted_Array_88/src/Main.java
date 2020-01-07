public class Main {

    public static void main(String[] args) {
	    var solution = new Solution();
	    var nums1 = new int[]{-1,0,0,0,3,0,0,0,0,0,0};
	    var nums2 = new int[]{-1,-1,0,0,1,2};
	    solution.merge(nums1, 5, nums2, 6);

        for (var item:
             nums1) {
            System.out.println(item);
        }
    }
}
