package leetcode_problems.sheet_arsh.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedCollection {

    /*
    381. Insert Delete GetRandom O(1) - Duplicates allowed
    RandomizedCollection is a data structure that contains a collection of numbers,
     possibly duplicates (i.e., a multiset).
     It should support inserting and removing specific elements and also reporting a random element.

     Implement the RandomizedCollection class:
     - RandomizedCollection() Initializes the empty RandomizedCollection object.
     - bool insert(int val) Inserts an item val into the multiset, even if the item is already present.
       Returns true if the item is not present, false otherwise.
     - bool remove(int val) Removes an item val from the multiset if present.
       Returns true if the item is present, false otherwise.
       Note that if val has multiple occurrences in the multiset, we only remove one of them.
     - int getRandom() Returns a random element from the current multiset of elements.
       The probability of each element being returned is linearly related to the number
       of the same values the multiset contains.

     You must implement the functions of the class such that each function works on average O(1) time complexity.
     Note: The test cases are generated such that getRandom will only be called if there is at least one item in
     the RandomizedCollection.
     */

    HashMap<Integer, Integer> map;
    ArrayList<Integer> check;

    public RandomizedCollection() {
        map = new HashMap<>();
        check = new ArrayList<>();
    }

    public boolean insert(int val) {
        boolean bool = map.containsKey(val);
        map.put(val, map.getOrDefault(val, 0) + 1);
        check.add(val);
        return !bool;
    }

    public boolean remove(int val) {
        boolean bool = map.containsKey(val);
        if (bool && map.get(val) > 1) map.replace(val, map.getOrDefault(val, 0), map.getOrDefault(val, 0) - 1);
        else map.remove(val);
        check.remove((Integer) val);
        return bool;
    }

    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(0, check.size());
        return check.get(index);
    }

    public static void main(String[] args) {
        RandomizedCollection obj = new RandomizedCollection();
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.getRandom());
    }
}
