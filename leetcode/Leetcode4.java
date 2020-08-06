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
        //第二个设计巧妙的点，&来判断奇偶性：奇数&1==1，偶数&1==0
        if((length&1)==0){
            return (float)(right+left)/2;
        }else {
            return right;
        }

    }

    /**
     * 分治法，求第k小的数特殊情况，求中位数，分治法，分而治之
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays3(int[] nums1, int[] nums2){

        int m = nums1.length;
        int n = nums2.length;
        //奇数和偶数找到中位数的位置，如果是奇数的话，两个位置一样
        int left = (m+n+1)/2;
        int right = (m+n+2)/2;
        return (getKth(nums1,0,m-1,nums2,0,n-1,left)+getKth(nums1,0,m-1,nums2,0,
                n-1,right))*0.5;
    }

    /**
     * 求第K大的数
     * @param nums1
     * @param start1
     * @param end1
     * @param nums2
     * @param start2
     * @param end2
     * @param k
     * @return
     */
    public static double getKth(int[] nums1, int start1, int end1 , int[] nums2, int start2, int end2, int k){
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }

    }

    //个人练习
    public static double getKth2(int[] nums1, int start1, int end1 , int[] nums2, int start2, int end2, int k){

        int length1 = end1-start1+1;
        int length2 = end2-start2+1;
        if(length1>length2){
            return getKth2(nums2, start2,end2,nums1,start1,end1 ,k);
        }
//        if (k == 0) {
//            return nums1[start1] < nums2[start2] ? nums1[start1] : nums2[start2];
//        }
//        if(length1 == 1) {
//           return  nums2[k-1-1];
//        }

        //上面这样定义是有问题的，为什么自己仔细想想,怎么可能k是0呢？
        if(k==1){
            return Math.min(nums1[start1], nums2[start2]);
        }
        if(length1 == 0){
            //开始这样写也有问题
//            return nums2[k];
            return nums2[start2 + k - 1];
        }
        int i = start1+Math.min(length1,k/2)-1;
        int j = start2+ Math.min(length2,k/2)-1;
        if(nums1[i]<nums2[j]){
            //这句话有问题，问题出现在最后一个参数
//            return getKth2(nums1, i + 1, end1, nums2, start2, end2, k - i + 1);
            return getKth2(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }else {
            return getKth2(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));

        }

    }


    /**
     * 解法4 同样是通过二分，但是这个方法略复杂，需要认真考虑
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays4(int[] nums1, int[] nums2){



        return 0;
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


        System.out.println("测试"+1/2);



    }


}
