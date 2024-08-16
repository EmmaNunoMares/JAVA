package utilities;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 15);
        map.put("e", 5);
        map.put("f", 6);

        String outString = "";
        int outInt = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            if(entry.getValue()>outInt){
                outInt = entry.getValue();
                outString = entry.getKey();
            }
        }
        System.out.println(outString + " " +outInt);
    }
}
