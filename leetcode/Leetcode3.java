import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.HashSet;

public class Leetcode3 {


    /**
     * 找到字符串长度 时间复杂度o（n^3）
     * @param s
     * @return
     */
    public static int findLength(String s){

        int max = 0;
        for (int i=0; i<s.length(); i++){
            for(int j=0; j<s.length(); j++){
                int temp = numbers(i, j, s);
                max = Math.max(max, temp);
            }

        }

        return max;

    }

    /**
     * 找到长度
     * @param i
     * @param j
     * @param s
     * @return
     */
    public static int numbers(int i, int j, String s){

        HashSet<Character> characters = new HashSet<>();
        for(int k= i; k<=j; k++){
            char ch = s.charAt(k);
            if(!characters.contains(ch)){
                characters.add(ch);
            }else {
                return characters.size();

            }

        }

        return characters.size();


    }

    /**
     * 滑动窗口 这个版本时间复杂度为 O（n^2）
     * @param s
     * @return
     */
    public static int slipWindow(String s){
        int max = 0;
        for(int i=0; i< s.length(); i++){
            HashSet<Character> characters = new HashSet<>();
            characters.add(s.charAt(i));
            int j=i+1;
            while (j <s.length()){
                if(characters.contains(s.charAt(j))){
                    break;
                }
                characters.add(s.charAt(j));
                j++;
            }
            max = Math.max(max, j - i);
        }
        return max;
    }


    /**
     * 简化滑动窗口 时间复杂度变为o（n） 这个设计的巧妙之处就是begin指针的移动，巧妙,如果一直有值就一直吐出去
     * 但是这个是一个一个吐出去，考虑一个字符串 bacabd 第一次回连续吐出 b和a 如果一步吐出去的话就更简化了
     * @param s
     * @return
     */
    public static int easySlipWindow(String s){

        int max = 0, begin = 0, end = 0;
        HashSet<Character> characters = new HashSet<>();
        while(begin< s.length() && end< s.length()){

            if(!characters.contains(s.charAt(end))){
                characters.add(s.charAt(end++));
                max = Math.max(max, end - begin);
            }else {

                characters.remove(s.charAt(begin++));
            }

        }

        return max;

    }


    /**
     * 这个使用空间换时间，时间复杂度降到了o（n），为了记住位置还使用了 HashMap
     * 这个使用的时间略长
     * @param s
     * @return
     */
    public static int moreEasyWay(String s){
        int max =0, begin = 0, end = 0;
        HashMap characters = new HashMap<Character,Integer>();
        while (begin< s.length()&& end< s.length()){

            if(!characters.containsKey(s.charAt(end))){

                characters.put(s.charAt(end), end++);
                max = Math.max(max, end - begin);

            }else {

                begin = (Integer) characters.get(s.charAt(end))+1;
                characters = new HashMap<Character,Integer>();
                end = begin;

            }


        }
        return max;
    }

    /**
     * 这个只使用了一个 HashMap
     * @param s
     * @return
     */
    public static int getLength(String s){
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int begin=0, end=0; end<s.length(); end++){
            if (map.containsKey(s.charAt(end))){
                //其实没太想明白这个 Math.max 的作用,解释说是因为这个没有实现删除map中的元素,就是说新的begin不能比旧的小
                begin = Math.max(begin, map.get(s.charAt(end)) + 1);
                //测试一下，会出现错误
//                begin = map.get(s.charAt(end))+1;
            }
            map.put(s.charAt(end), end);
            max = Math.max(max, end - begin + 1);
        }
        return max;
    }

    /**
     * 网上看到的基本属于最简的方法，使用数组
     * @param s
     * @return
     */
    public static int useArrays(String s){
      int max =0;
      int[] array = new int[128];
      for(int begin =0 , end = 0; end< s.length(); end++){
          begin = Math.max(begin, array[s.charAt(end)] + 1);
          array[s.charAt(end)] = end;
          max = Math.max(max, end - begin + 1);
      }
      return  max;
    }


    public static void main(String[] args) {


        System.out.println(findLength("abcd"));
        System.out.println(slipWindow("aaa"));
        System.out.println(easySlipWindow("bacabd"));
        System.out.println(moreEasyWay("abcedab"));
        System.out.println(getLength("abcdabcaddb"));
        System.out.println(useArrays("abcdab"));


    }
}
