package Java;

import java.util.ArrayList;
import java.util.List;

class RecentCounter {
    private int base;
    private List<Integer> arr;
    public RecentCounter() {
        arr = new ArrayList<Integer>();
        base = 0;
    }
    
    public int ping(int t) {
        arr.add(t);
        if (t - arr.get(base) <= 3000) return arr.size() - base;
        else{
            while (base < arr.size() && t - arr.get(base) > 3000) base++;
            return arr.size() - base;
        }
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */