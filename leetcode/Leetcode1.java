import javax.swing.*;
import java.util.HashMap;

/**
 * author: hanyichao
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Leetcode1 {

    /**
     * 复杂解法，双重for循环，最后的时间复杂度为O（n²）,空间复杂度：O（1）
     * @param info
     * @param k
     * @return
     */
    public int[] calculate(int[] info, int k){
        if(info==null){
            return null;
        }
        int[] result= new int[2];
        for (int i = 0; i < info.length; i++) {
            int m = k-result[i];
            for (int j = i+1; j <info.length ; j++) {
                if (info[j]==m){
                    result[0]=i;
                    result[1]=j;
                    return result;

                }
            }

        }
        return null;
    }


        public int[] calculate1(int[] info, int k){
            if(info==null){
                return null;
            }
            int[] result= new int[2];
            for (int i = 0; i < info.length-1; i++) {
                int m = k-result[i];
                int j =i+1;
                while (j < info.length) {
                    if (info[j]==m){
                        result[0]=i;
                        result[1]=j;
                        return result;
                    }else {
                        j++;
                    }
                }
            }
            return null;
        }

        /**
         * 时间复杂度为O（n）,空间复杂度：O（n）
         * @param info
         * @param k
         * @return
         */
        public int[] calculate3(int[] info, int k){
            HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
            for (int i = 0; i <info.length ; i++) {
                integerIntegerHashMap.put(info[i], i);
            }
            for (int i = 0; i < info.length ; i++) {
                int temp = k-info[i];
                if(integerIntegerHashMap.containsKey(temp) && integerIntegerHashMap.get(temp)!=null){
                    return new int[]{i, integerIntegerHashMap.get(temp)};
                }
            }
            return null;
        }

        /**
         * 时间复杂度为O（n）,空间复杂度：O（n）
         * @param info
         * @param k
         * @return
         */
        public int[] calculate4(int[] info, int k){
            HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
            for (int i = 0; i < info.length ; i++) {
                int temp = k-info[i];
                if(integerIntegerHashMap.containsKey(temp) && integerIntegerHashMap.get(temp)!=null){
                    return new int[]{i, integerIntegerHashMap.get(temp)};
                }
                integerIntegerHashMap.put(info[i], i);
            }
            return null;
        }


    }
