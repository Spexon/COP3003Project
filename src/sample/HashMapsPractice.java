/**
 * @Author Vladimir hardy
 */
package sample;

import java.util.HashMap;

class HashMapsPractice {

    /**
     * @param fruitBowl
     * @brief Adds values to a HashMap
     */
    static void addElements(HashMap<String, String> fruitBowl) {

        fruitBowl.put("Apple", "Green");
        fruitBowl.put("Cherry", "Red");
        fruitBowl.put("Orange", "Orange");
        fruitBowl.put("Banana", "Yellow");
        //fruitBowl.put("Apple", "Red"); //This is a duplicate, it will override the green apple
    }
}
