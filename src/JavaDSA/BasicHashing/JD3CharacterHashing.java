package JavaDSA.BasicHashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JD3CharacterHashing {

    static int[] charFrequency(String str, int N){
        int freqArr[] = new int[26];

        for(int i = 0; i<N; i++){
            freqArr[str.charAt(i) - 'a']++;
        }
        return freqArr;
    }

    static int[] charFrequencyWithHashMap(String str, int N){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<N; i++){
            if(map.containsKey(str.charAt(i)-'a')) {
               map.put(str.charAt(i)-'a', map.get(str.charAt(i)-'a')+1);
            }
            else{
                map.put(str.charAt(i)-'a', 1);
            }
        }
        int result[] = new int[26];
        for(int i = 0; i<N; i++){
            if(map.containsKey(str.charAt(i) - 'a')){
                result[str.charAt(i)-'a'] = map.get(str.charAt(i)-'a');
            }
            else{
                result[str.charAt(i)-'a'] = 0;
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for(Map.Entry<Integer, Integer> entry:entries){
            System.out.print(entry + " ");
        }
        return result;
    }
    public static void main(String[] args) {
        String str = "abcabcabcrtyteyttt";
//        int result[] = charFrequency(str, str.length());
        int result[] = charFrequencyWithHashMap(str, str.length());
        for (int i:result){
            System.out.print(i + " ");
        }
    }
}
