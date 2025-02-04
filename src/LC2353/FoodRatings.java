package LC2353;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Food implements Comparable<Food> {
    public int foodRating;
    public String foodName;

    public Food(int foodRating, String foodName) {
        this.foodRating = foodRating;
        this.foodName = foodName;
    }

    @Override
    public int compareTo(Food otherFood) {
        if (this.foodRating == otherFood.foodRating) {
            return this.foodName.compareTo(otherFood.foodName);
        }
        return -1 * Integer.compare(this.foodRating, otherFood.foodRating);
    }
}

public class FoodRatings {
    private Map<String, Integer> foodRatingsMap;
    private Map<String, String> foodCuisinesMap;
    private Map<String, PriorityQueue<Food>> cuisineQueueMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRatingsMap = new HashMap<>();
        foodCuisinesMap = new HashMap<>();
        cuisineQueueMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodRatingsMap.put(foods[i], ratings[i]);
            foodCuisinesMap.put(foods[i], cuisines[i]);
            cuisineQueueMap.computeIfAbsent(cuisines[i], key -> new PriorityQueue<>()).add(new Food(ratings[i], foods[i]));
        }   
    }
    
    public void changeRating(String food, int newRating) {
        foodRatingsMap.put(food, newRating);
        String cuisine = foodCuisinesMap.get(food);
        cuisineQueueMap.get(cuisine).add(new Food(newRating, food));
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Food> queue = cuisineQueueMap.get(cuisine);
        Food highestRatedFood = queue.peek();

        while (highestRatedFood.foodRating != foodRatingsMap.get(highestRatedFood.foodName)) {
            queue.poll();
            highestRatedFood = queue.peek();
        }

        return highestRatedFood.foodName;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */