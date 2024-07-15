package CompetitiveProgramming.SearchingSorting;

import java.util.*;

public class GroupAnagrams {

    public static String getSortedString(String s){
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    public static void groupAnagrams(List<String> l){
        HashMap<String,List<String>> hashMap;
        hashMap = new HashMap<>();

        for(String s:l){
            String key = getSortedString(s);
            if(hashMap.get(key)!=null){
                hashMap.get(key).add(s);
            }
            else{
                hashMap.put(key,new ArrayList<>());
                hashMap.get(key).add(s);
            }
        }

        //iterate
        for(String key:hashMap.keySet()){
            System.out.println(hashMap.get(key));
        }
    }

    public static void main(String[] args) {
        List<String> l = new ArrayList<>(List.of("abc","acb","bca","cab","cat","bat","bta","ccc","tac"));
        groupAnagrams(l);
    }
}
