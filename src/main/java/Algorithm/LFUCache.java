package Algorithm;

import java.util.ArrayList;
import java.util.Hashtable;

class LFUCache {
    private ArrayList<Integer> list = new ArrayList<>();
    private ArrayList<Integer> noUseList = new ArrayList<>();
    private Hashtable<Integer, Integer> table = new Hashtable<>();
    private int max = 0;

    public LFUCache(int capacity) {
        max = capacity;

    }

    public int get(int key) {
        if (table.size() == 0) {
            return -1;
        }

        if (table.containsKey(key)) {
            list.remove(Integer.valueOf(key));
            noUseList.remove(Integer.valueOf(key));
            list.add(key);
            return table.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (max == 0) {
            return;
        }

        if(table.containsKey(key)){
            list.remove(Integer.valueOf(key));
            noUseList.remove(Integer.valueOf(key));
        }else{
            if (table.size() >= max) {
                if (noUseList.size() != 0) {
                    table.remove(noUseList.get(0));
                    noUseList.remove(0);
                } else {
                    table.remove(list.get(0));
                }
                list.remove(0);
            }
            noUseList.add(key);
        }
        list.add(key);
        table.put(key, value);
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(2,6);
        lfuCache.get(1);
        lfuCache.put(1,5);
        lfuCache.put(1,2);
        lfuCache.get(1);
        lfuCache.get(2);
    }
}