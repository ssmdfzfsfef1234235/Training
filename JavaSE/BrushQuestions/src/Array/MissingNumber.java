package Array;
/*
* 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
* 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */

public class MissingNumber {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(MissingNumber.missingNumber(ints));
    }

    public static int missingNumber(int[] nums) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                break;
            }
        }
        return i;
    }
}
