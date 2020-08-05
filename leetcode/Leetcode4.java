public class Leetcode4 {

    /**
     * Time complex: O（m+n)
     * Runtime: 149 ms, faster than 5.01% of Java online submissions for Median of Two Sorted Arrays.
     * Memory Usage: 51.2 MB, less than 5.31% of Java online submissions for Median of Two Sorted Arrays.
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int first = nums1.length, second = nums2.length;
        int mid = (first + second)/2;
        double result = 0.0;
        int[] array = new int[first+second];
        int count = 0;
        if(first==0){
          return oZZ(nums2, second);
        }
        if(second ==0){
            return oZZ(nums1, first);
        }
        for (int i = 0, j = 0; count <= mid ;) {

            if(i<first && j<second){
                if(nums1[i]<=nums2[j] ){
                    array[count++]= nums1[i];
                    i++;
                }else {
                    array[count++]= nums2[j];
                    j++;
                }
            }else if(i<first && j>=second){
                array[count++]= nums1[i];
                i++;
            }else if(i>=first && j<second){
                array[count++]= nums2[j];
                j++;
            }

        }
        result = oZZ(array, first + second);
        return result;

    }

    /**
     * 辅助函数，判断奇数和偶数
     * @param array
     * @param length
     * @return
     */
    public static float oZZ(int[] array, int length){
        float result = 0;
        int mid = length/2;
        if (length % 2 == 0) {
            result = (float)(array[mid]+array[ mid-1])/2;
        }else {
            result = (float)array[mid];
        }
        return result;
    }




    public static void main(String[] args) {
//        int x =5;
//        System.out.println((int)x/2);

        int[] num1 = {2,3};
        int[] num2 = {2,3};
//        double x= (float) 5/2;
//        System.out.println(x);
        System.out.println(findMedianSortedArrays(num1,num2));

    }


}
