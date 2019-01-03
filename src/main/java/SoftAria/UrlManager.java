package SoftAria;

import java.util.*;

public class UrlManager {
    private Hashtable<String, String> today;
    private Hashtable<String, String> yesterday;

    public UrlManager(Hashtable<String, String> today, Hashtable<String, String> yesterday) {
        this.today = today;
        this.yesterday = yesterday;
    }

    public HashMap<String, HashSet<String>> UrlsAnalyzer(){

        HashSet<String> added = new HashSet<>();
        HashSet<String> changed = new HashSet<>();
        HashSet<String> removed = new HashSet<>();

        for (String key: today.keySet()
             ) {
            if (yesterday.containsKey(key)){
                if(!yesterday.get(key).equals(today.get(key))){
                    changed.add(key);
                }
            }
            else{
                added.add(key);
            }
        }
        for (String key : yesterday.keySet()
             ) {
            if(!today.containsKey(key)){
                removed.add(key);
            }
        }

        HashMap<String, HashSet<String>> result = new HashMap<>();
        result.put("added", added);
        result.put("changed", changed);
        result.put("removed", removed);

        return result;
    }
}
