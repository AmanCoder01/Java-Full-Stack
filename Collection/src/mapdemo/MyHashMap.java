package mapdemo;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("three",3);
//        map.put(null,7);
        map.put(null,9);

        System.out.println(map.get("one"));
        System.out.println(map.get(null));

        if(map.containsKey("four")){
            System.out.println(map.get("four"));
        }

        for(String key : map.keySet()){
            System.out.println(key+"->"+map.get(key));
        }


        for(Integer value : map.values()){
            System.out.println(value);
        }

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }


        map.forEach((key,value)->{
            System.out.println(key);
            System.out.println(value);
        });
    }
}
