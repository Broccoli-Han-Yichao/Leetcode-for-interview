import com.sun.org.apache.regexp.internal.RE;

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
     * 辅助函数，判断奇数和偶数，然后返回中位数的结果
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

    /**
     * 一种新的方法，复杂度是一样的，但是使用了一种新的思路
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2){

        int first = nums1.length, second = nums2.length;
        int length = first+ second;
        int left= -1, right =-1;
        int start1 = 0, start2= 0;
        //并没有真实的创建数组或者说，在数组中存储具体的值，而是用左右两个指针
        //然后仅仅通过i来迭代次数，不实际使用i的值
        for (int i = 0; i <= length/2; i++) {
            //这里赋值的方法特别巧妙
            left = right;
            //但如果nums2数组此刻已经没有数字了，
            //继续取数字nums2[start2]，则会越界，
            //所以判断下start2是否大于数组长度了，
            //这样 || 后边的就不会执行了，也就不会导致错误了，
            //所以增加为start1<first &&(start2>=second||nums1[start1]<nums2[start2])
            if(start1<first &&(start2>=second||nums1[start1]<nums2[start2])){
                right = nums1[start1++];
            }else {
                right = nums2[start2++];
            }

        }
        //第二个设计巧妙的点，&来判断奇偶性
        if((length&1)==0){
            return (float)(right+left)/2;
        }else {
            return right;
        }

    }








    public static void main(String[] args) {
//        int x =5;
//        System.out.println((int)x/2);

        int[] num1 = {2,3};
        int[] num2 = {2,3};
//        double x= (float) 5/2;
//        System.out.println(x);
        System.out.println(findMedianSortedArrays(num1,num2));


        System.out.println(1&7);
        System.out.println(1&8);
        //但如果nums2数组此刻已经没有数字了，
        // 继续取数字nums2[start2]，则会越界，
        // 所以判断下start2是否大于数组长度了，
        // 这样 || 后边的就不会执行了，也就不会导致错误了，
        // 所以增加为start1<first &&(start2>=second||nums1[start1]<nums2[start2])

        System.out.println(findMedianSortedArrays2(num1,num2));



    }


}
