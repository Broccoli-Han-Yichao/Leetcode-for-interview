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


    public static void main(String[] args) {


        System.out.println(findLength("abcd"));
        System.out.println(slipWindow("aaa"));


    }
}
