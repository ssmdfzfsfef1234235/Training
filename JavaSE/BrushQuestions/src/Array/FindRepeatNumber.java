package Array;
/*
* 找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
* 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
* 请找出数组中任意一个重复的数字。
*/
public class FindRepeatNumber {
    public FindRepeatNumber() {
    }

    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 2, 2, 3, 4, 5, 6, 7};
        System.out.println(FindRepeatNumber.findRepeatNumber(ints));

    }

    public static int findRepeatNumber(int[] nums) {
        int a = 0;
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();

        findRepeatNumber.quicksort(nums, 0, nums.length-1);

        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]){
                a=nums[i];
            }

        }

        return a;
    }

    //快速排序
    private int getMiddle(int[] sortArray, int low, int high) {
        int key = sortArray[low];
        while (low < high) {
            while (low < high && sortArray[high] >= key) {
                high--;
            }

            sortArray[low] = sortArray[high];
            while (low < high && sortArray[low] <= key) {
                low++;
            }
            sortArray[high] = sortArray[low];
        }
        sortArray[low] = key;
        return low;
    }

    public void quicksort(int[] sortArray, int low, int high) {
        if (low < high) {
            int middle = getMiddle(sortArray, low, high);
            quicksort(sortArray, low, middle - 1);
            quicksort(sortArray, middle + 1, high);
        }
        System.out.println("第二种写法的输出：");
        sprint(sortArray);
    }

    public void sprint(int[] arrays){
        System.out.println("排序后的数组是：");
        for(int i = 0; i <arrays.length;i++){
            System.out.print(arrays[i] + " ");
        }
        System.out.println();
    }

   /* // 二分查找递归实现
    public static boolean binSearch(int srcArray[], int start, int end, int key) {
        int mid = (end - start) / 2 + start;
        if (srcArray[mid] == key) {
            return true;
        }
        if (start >= end) {
            return false;
        } else if (key > srcArray[mid]) {
            return binSearch(srcArray, mid + 1, end, key);
        } else if (key < srcArray[mid]) {
            return binSearch(srcArray, start, mid - 1, key);
        }
        return false;
    }*/
}
