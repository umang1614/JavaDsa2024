package JavaCollectionFrameWork;
import java.util.*;
public class MapLearn {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("UB", "Umang Bhatia");
        map.put("UT", "Utkarsh Bhatia");
        map.put("YB", "Yash Bhatia");
//        map.put("UB", "Utsav Bhatia");

        ArrayList<String> keys = new ArrayList<>(map.keySet());
        System.out.println(keys);
        Collection<String> values = map.values();
        System.out.println(values);
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for(Map.Entry<String, String> entry:entries){
            System.out.println(entry);
        }
        System.out.println(map);
        map.remove("YB");
        System.out.println(map);
    }
}
