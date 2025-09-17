class FoodRatings {

    Map<String, Integer> foodRatingMap;
    Map<String, String> foodCuisineMap;
    Map<String, PriorityQueue<Food>> cuisineFoodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRatingMap = new HashMap<>();
        foodCuisineMap = new HashMap<>();
        cuisineFoodMap = new HashMap<>();
         for (int i = 0; i < foods.length; ++i) {
            foodRatingMap.put(foods[i], ratings[i]);
            foodCuisineMap.put(foods[i], cuisines[i]);
            cuisineFoodMap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>()).add(new Food(ratings[i], foods[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        foodRatingMap.put(food, newRating);
        String cuisineName = foodCuisineMap.get(food);
        cuisineFoodMap.get(cuisineName).add(new Food(newRating, food));
    }
    
    public String highestRated(String cuisine) {
         Food highestRated = cuisineFoodMap.get(cuisine).peek();
        while (foodRatingMap.get(highestRated.name) != highestRated.rating) {
            cuisineFoodMap.get(cuisine).poll();
            highestRated = cuisineFoodMap.get(cuisine).peek();
        }        
        return highestRated.name;
    }


    static class Food implements Comparable<Food>{
        int rating;
        String name;
        Food(int rating, String name){
            this.name = name;
            this.rating = rating;
        }

        @Override
        public int compareTo(Food o){
            if(this.rating == o.rating){
                return this.name.compareTo(o.name);
            }
            return o.rating - this.rating;
        }




    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */